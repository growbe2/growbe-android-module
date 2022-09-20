package ca.berlingoqc.growbe_android_module.services

import android.content.Context
import android.util.Log
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.proto.Module
import com.pedro.encoder.input.audio.CustomAudioEffect
import com.pedro.rtmp.utils.ConnectCheckerRtmp
import com.pedro.rtplibrary.rtmp.RtmpCamera1
import com.pedro.rtplibrary.rtmp.RtmpCamera2

private const val TAG = "StreamingService"


class StreamingService: ConnectCheckerRtmp {

    private var rtmpCamera1: RtmpCamera1? = null;
    private var isPublishing = false;

    private var previous_config: Module.PhoneStreamingConfig? = null;

    private var streamingData = Module.PhoneStreamingData.newBuilder();

    fun initialize(context: Context) {
        rtmpCamera1 = RtmpCamera1(context, this);
        rtmpCamera1?.setLogs(false);
        rtmpCamera1?.setFpsListener {
            if (streamingData.status == Module.PhoneStreamingStatus.RUNNING) {
                streamingData.fps = it.toFloat()
                dataStore.streaming = streamingData.build();
            }
        }
    }

    fun streamingConfigChanged() {
        Log.w(TAG, "receive streaming config $rtmpCamera1");
        val config = dataStore.streamingConfig!!;
        if (config.activated) {
            if (!isPublishing) {
                if (rtmpCamera1!!.prepareAudio() && rtmpCamera1!!.prepareVideo()) {
                    when (config.output) {
                        Module.PhoneStreamingOutput.RECORD -> rtmpCamera1?.startRecord(config.url)
                        Module.PhoneStreamingOutput.STREAM -> rtmpCamera1?.startStream(config.url)
                        Module.PhoneStreamingOutput.STREAM_N_RECORD -> {
                            val part = config.url.split(";")
                            if (part.size == 2) {
                                rtmpCamera1?.startStreamAndRecord(part[0], part[1])
                            } else {
                                Log.e(TAG, "invalid config url for stream and record ${config.url}")
                                return;
                            }
                        }
                        else -> {
                            Log.e(TAG, "config.output unrecognized");
                            return;
                        }
                    }
                    if (config.camera == Module.PhoneStreamingCamera.BACK) {
                        rtmpCamera1?.switchCamera();
                    }

                    if (config.faceDetection) {
                        enableFaceDetection();
                    }

                    if (config.light) {
                        rtmpCamera1?.enableLantern();
                    }

                    if (config.autoFocus) {
                        rtmpCamera1?.enableAutoFocus();
                    }

                    if (!config.audio) {
                        rtmpCamera1?.disableAudio();
                    }

                    if (config.stabilization) {
                        rtmpCamera1?.enableVideoStabilization();
                    }

                    if (config.zoom > 0) {
                        rtmpCamera1?.setZoom(config.zoom);
                    }

                    isPublishing = true;
                    previous_config = config;
                } else {
                    Log.e(TAG, "COULD NOT PREPARE CAMERA");
                }
            } else {
                Log.e(TAG, "already publishing");
                if (previous_config != null) {
                    if (previous_config!!.camera != config.camera) {
                        rtmpCamera1?.switchCamera();
                    }

                    if (previous_config!!.autoFocus != config.autoFocus) {
                        if (config.autoFocus) {
                            rtmpCamera1?.enableAutoFocus();
                        } else {
                            rtmpCamera1?.disableAutoFocus();
                        }
                    }

                    if (previous_config!!.audio != config.audio) {
                        if (config.audio) {
                            rtmpCamera1?.enableAudio();
                        } else {
                            rtmpCamera1?.disableAudio();
                        }
                    }

                    if (previous_config!!.light != config.light) {
                        if (config.light) {
                            rtmpCamera1?.enableLantern();
                        } else {
                            rtmpCamera1?.disableLantern();
                        }
                    }

                    if (previous_config!!.stabilization != config.stabilization) {
                        if (config.stabilization) {
                            rtmpCamera1?.enableVideoStabilization();
                        } else {
                            rtmpCamera1?.disableVideoStabilization();
                        }
                    }

                    if (previous_config!!.faceDetection != config.faceDetection) {
                        if (config.faceDetection) {
                            enableFaceDetection();
                        } else {
                            disableFaceDetect();
                        }
                    }

                    if (previous_config!!.zoom != config.zoom) {
                        rtmpCamera1?.setZoom(config.zoom);
                    }

                }
                previous_config = config;
            }
        } else {
            if (isPublishing) {
                isPublishing = false;
                if (rtmpCamera1?.isStreaming == true) {
                    rtmpCamera1?.stopStream();
                    Log.i(TAG, "stop publishing")
                }
                if (rtmpCamera1?.isRecording == true) {
                    rtmpCamera1?.stopRecord();
                    Log.i(TAG, "stop recording")
                }

                streamingData.clear();
                streamingData.status = Module.PhoneStreamingStatus.STOPPED;
                flushData();
                flushData();
            } else {
                Log.e(TAG, "not publishing");
            }
        }
    }

    private fun disableFaceDetect() {
        rtmpCamera1?.disableFaceDetection();
    }

    override fun onAuthErrorRtmp() {
        Log.i(TAG, "onAuthErrorRtmp");
        streamingData.status = Module.PhoneStreamingStatus.ERROR
        streamingData.error = "onAuthErrorRtmp";
        flushData()
    }

    override fun onAuthSuccessRtmp() {
        Log.i(TAG, "onAuthSuccessRtmp");
    }

    override fun onConnectionFailedRtmp(reason: String) {
        Log.i(TAG, "onConnectionFailedRtmp $reason");
        streamingData.status = Module.PhoneStreamingStatus.ERROR
        streamingData.error = "onConnectionFailedRtmp: $reason"
        flushData()
    }

    override fun onConnectionStartedRtmp(rtmpUrl: String) {
        Log.i(TAG, "onConnectionStartedRtmp $rtmpUrl")
        streamingData.status = Module.PhoneStreamingStatus.RUNNING
        flushData();
    }

    override fun onConnectionSuccessRtmp() {
        Log.i(TAG, "onConnectionSuccessRtmp");

    }

    override fun onDisconnectRtmp() {
        Log.i(TAG, "onDisconnectRtmp");
        streamingData.error = "onDisconnectRtmp";
        streamingData.status = Module.PhoneStreamingStatus.ERROR;
        flushData();
    }

    override fun onNewBitrateRtmp(bitrate: Long) {
        Log.i(TAG, "onNewBitrateRtmp $bitrate");
        streamingData.bitrate = bitrate.toFloat();
        flushData();
    }

    private fun flushData() {
        dataStore.streaming = streamingData.build();
    }

    private fun enableFaceDetection() {
        val enable = rtmpCamera1?.enableFaceDetection { faces, _, _ ->
            run {
                streamingData.clearFaces();
                faces.forEach {
                    streamingData.addFaces(
                        Module.CameraFace.newBuilder()
                            .setId(it.id)
                            .setScore(it.score)
                            .setRect(
                                Module.Rect.newBuilder().setTop(it.rect.top)
                                    .setBottom(it.rect.bottom).setLeft(it.rect.left)
                                    .setRight(it.rect.right).build()
                            )
                            .setLeftEye(
                                Module.Point.newBuilder().setX(it.leftEye?.x ?: 0).setY(it.leftEye?.y ?: 0)
                                    .build()
                            )
                            .setRightEye(
                                Module.Point.newBuilder().setX(it.rightEye?.x ?: 0).setY(it.rightEye?.y ?: 0)
                                    .build()
                            )
                            .setMouth(
                                Module.Point.newBuilder().setX(it.mouth?.x ?: 0).setY(it.mouth?.y ?: 0).build()
                            )
                            .build()
                    );
                }
                flushData();
            }
        }
        Log.e(TAG, "FACE DETECTION $enable");
    }
}