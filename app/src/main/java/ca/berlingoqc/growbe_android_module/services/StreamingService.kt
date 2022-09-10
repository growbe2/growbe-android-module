package ca.berlingoqc.growbe_android_module.services

import android.content.Context
import android.util.Log
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.proto.Module
import com.pedro.rtmp.utils.ConnectCheckerRtmp
import com.pedro.rtplibrary.rtmp.RtmpCamera1
import com.pedro.rtplibrary.rtmp.RtmpCamera2

private const val TAG = "StreamingService"


class StreamingService: ConnectCheckerRtmp {

    private var rtmpCamera1: RtmpCamera1? = null;
    private var isPublishing = false;

    private var previous_url = "";
    private var previous_camera =  Module.PhoneStreamingCamera.BACK;

    private var streamingData = Module.PhoneStreamingData.newBuilder();

    fun initialize(context: Context) {
        rtmpCamera1 = RtmpCamera1(context, this);
        rtmpCamera1?.setLogs(false);
        rtmpCamera1?.setFpsListener {
            streamingData.fps = it.toFloat()
            dataStore.streaming = streamingData.build();
        }
    }

    fun streamingConfigChanged() {
        Log.w(TAG, "receive streaming config $rtmpCamera1");
        val config = dataStore.streamingConfig!!;
        if (config.activated) {
            if (!isPublishing) {
                if (rtmpCamera1!!.prepareAudio() && rtmpCamera1!!.prepareVideo()) {
                    Log.i(TAG, "start publishing")
                    rtmpCamera1?.startStream(config.url);
                    if (config.camera == Module.PhoneStreamingCamera.BACK) {
                        rtmpCamera1?.switchCamera();
                        rtmpCamera1?.enableLantern();
                    }
                    isPublishing = true;
                    previous_camera = config.camera;
                    previous_url = config.url;

                } else {
                    if (previous_camera != config.camera) {
                        rtmpCamera1?.switchCamera();
                        previous_camera = config.camera;
                    }
                    Log.e(TAG, "cannot start streaming acquiring codec");
                }
            } else {
                Log.e(TAG, "already publishing");
            }
        } else {
            if (isPublishing) {
                isPublishing = false;
                rtmpCamera1?.stopStream();

                Log.i(TAG, "stop publishing")
            } else {
                Log.e(TAG, "not publishing");
            }
        }
    }

    override fun onAuthErrorRtmp() {
        Log.i(TAG, "onAuthErrorRtmp");
    }

    override fun onAuthSuccessRtmp() {
        Log.i(TAG, "onAuthSuccessRtmp");
    }

    override fun onConnectionFailedRtmp(reason: String) {
        Log.i(TAG, "onConnectionFailedRtmp $reason");
    }

    override fun onConnectionStartedRtmp(rtmpUrl: String) {
        Log.i(TAG, "onConnectionStartedRtmp $rtmpUrl");
    }

    override fun onConnectionSuccessRtmp() {
        Log.i(TAG, "onConnectionSuccessRtmp");
        val enable = rtmpCamera1?.enableFaceDetection { faces, scaleSensor, sensorOrientation ->
            run {
                var d = faces.map { "${it?.score} ${it?.mouth}"}.joinToString(" ")
                Log.i(TAG, "$d $scaleSensor $sensorOrientation");
                faces.map { it?.score }
            }
        }
        Log.e(TAG, "FACE DETECTION $enable");
    }

    override fun onDisconnectRtmp() {
        Log.i(TAG, "onDisconnectRtmp");
    }

    override fun onNewBitrateRtmp(bitrate: Long) {
        Log.i(TAG, "onNewBitrateRtmp $bitrate");
        streamingData.bitrate = bitrate.toFloat();
        dataStore.streaming = streamingData.build();
    }
}

public val streamingService = StreamingService();