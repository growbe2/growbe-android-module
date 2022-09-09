package ca.berlingoqc.growbe_android_module.services

import android.util.Log
import ca.berlingoqc.growbe_android_module.data.DataStore
import ca.berlingoqc.growbe_android_module.data.dataStore
import com.github.faucamp.simplertmp.RtmpHandler
import net.ossrs.yasea.SrsCameraView
import net.ossrs.yasea.SrsEncodeHandler
import net.ossrs.yasea.SrsPublisher
import net.ossrs.yasea.SrsRecordHandler
import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.net.SocketException


private const val TAG = "StreamingService"


class StreamingService : RtmpHandler.RtmpListener, SrsRecordHandler.SrsRecordListener, SrsEncodeHandler.SrsEncodeListener {

    private var publisher: SrsPublisher? = null;
    private var cameraView: SrsCameraView? = null;

    var width = 640;
    var height = 480;

    var isPublishing = false;

    fun initialize(cameraView: SrsCameraView) {
        this.cameraView = cameraView;
        this.cameraView?.cameraId = android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT
        publisher = SrsPublisher(this.cameraView)
        publisher?.setEncodeHandler(SrsEncodeHandler(this))
        publisher?.setRtmpHandler(RtmpHandler(this))
        publisher?.setRecordHandler(SrsRecordHandler(this))
        publisher?.setPreviewResolution(width, height)
        publisher?.setOutputResolution(width, height)
        publisher?.setVideoHDMode()
        publisher?.switchCameraFace(1);
        publisher?.startPublish("rtmp://stream.dev.growbe.ca/live/56837D-ewe?sign=1665338939352-78c908c97dafdfb6c164d95248833727");
        //publisher?.startAudio();
        publisher?.startCamera();
    }

    fun streamingConfigChanged() {

        Log.w(TAG, "receive streaming config");
        val config = dataStore.streamingConfig!!;
        if (config.activated) {
            if (!isPublishing) {
               isPublishing = true;
                Log.i(TAG, "start publishing")
            } else {
                Log.e(TAG, "already publishing");
            }
        } else {
            if (isPublishing) {
                publisher?.stopPublish();
                publisher?.stopCamera();
                publisher?.stopAudio();
                isPublishing = false;
                Log.i(TAG, "stop publishing")
            } else {
                Log.e(TAG, "not publishing");
            }
        }
    }

    override fun onRtmpConnecting(msg: String?) {
        Log.e(TAG, msg ?: "");
    }

    override fun onRtmpConnected(msg: String?) {
        Log.e(TAG, msg ?: "");
    }

    override fun onRtmpVideoStreaming() {
    }

    override fun onRtmpAudioStreaming() {
    }

    override fun onRtmpStopped() {
    }

    override fun onRtmpDisconnected() {
    }

    override fun onRtmpVideoFpsChanged(fps: Double) {
    }

    override fun onRtmpVideoBitrateChanged(bitrate: Double) {
    }

    override fun onRtmpAudioBitrateChanged(bitrate: Double) {
    }

    override fun onRtmpSocketException(e: SocketException?) {
    }

    override fun onRtmpIOException(e: IOException?) {
    }

    override fun onRtmpIllegalArgumentException(e: IllegalArgumentException?) {
    }

    override fun onRtmpIllegalStateException(e: IllegalStateException?) {
    }

    override fun onNetworkWeak() {
    }

    override fun onNetworkResume() {
    }

    override fun onEncodeIllegalArgumentException(e: IllegalArgumentException?) {
    }

    override fun onRecordPause() {
    }

    override fun onRecordResume() {
    }

    override fun onRecordStarted(msg: String?) {
    }

    override fun onRecordFinished(msg: String?) {
    }

    override fun onRecordIllegalArgumentException(e: IllegalArgumentException?) {
    }

    override fun onRecordIOException(e: IOException?) {
    }
}

public val streamingService = StreamingService();