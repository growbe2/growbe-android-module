package ca.berlingoqc.growbe_android_module

import android.Manifest
import android.content.Intent
import android.content.pm.ModuleInfo
import android.content.pm.PackageManager
import android.graphics.Camera
import android.hardware.camera2.CameraDevice
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.core.app.ActivityCompat
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.proto.Module
import ca.berlingoqc.growbe_android_module.services.PositionService
import ca.berlingoqc.growbe_android_module.services.SensorService
import ca.berlingoqc.growbe_android_module.services.StreamingService
import ca.berlingoqc.growbe_android_module.services.gatt.GattServerService
import ca.berlingoqc.growbe_android_module.services.streamingService
import ca.berlingoqc.growbe_android_module.services.ws.WebSocketService
import com.github.faucamp.simplertmp.RtmpHandler
import net.ossrs.yasea.SrsCameraView
import net.ossrs.yasea.SrsEncodeHandler
import net.ossrs.yasea.SrsPublisher
import net.ossrs.yasea.SrsRecordHandler
import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.net.SocketException


class SettingsActivity : AppCompatActivity(), RtmpHandler.RtmpListener, SrsRecordHandler.SrsRecordListener, SrsEncodeHandler.SrsEncodeListener {
    var width = 640;
    var height = 480;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        /*
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.settings, SettingsFragment())
                    .commit()
        }
        */
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        validatePermissions()

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //streamingService.initialize(findViewById(R.id.glsurfaceview_camera));

        var intent = Intent(this, GattServerService::class.java)
        startService(intent);

        intent = Intent(this, WebSocketService::class.java)
        startService(intent)

        intent = Intent(this, SensorService::class.java)
        startService(intent)

        intent = Intent(this, PositionService::class.java)
        startService(intent)



        var cameraView: SrsCameraView = findViewById(R.id.glsurfaceview_camera);
        cameraView.cameraId = android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;

        val publisher = SrsPublisher(cameraView)
        publisher.setEncodeHandler(SrsEncodeHandler(this))
        publisher.setRtmpHandler(RtmpHandler(this))
        publisher.setRecordHandler(SrsRecordHandler(this))
        publisher.setPreviewResolution(width, height)
        publisher.setOutputResolution(width, height)
        publisher.setVideoHDMode()
        publisher.setVideoSmoothMode()
        //publisher.startAudio();
        publisher.startCamera();

        publisher.startPublish("rtmp://stream.dev.growbe.ca/live/56837D-lol?sign=1665339381292-7d52f25a14a55eeed047948566c214dd");


    }

    private fun validatePermissions() {
        validatePermission(Manifest.permission.ACCESS_FINE_LOCATION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            validatePermissionS()
        } else {
            validatePermission(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun validatePermissionS() {
        validatePermission(Manifest.permission.CAMERA)
        validatePermission(Manifest.permission.RECORD_AUDIO)
        validatePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        validatePermission(Manifest.permission.BLUETOOTH_ADVERTISE)
        validatePermission(Manifest.permission.BLUETOOTH_CONNECT)
    }

    private fun validatePermission(permission: String) {
        if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)  {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 1)
        }
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }

    override fun onRtmpConnecting(msg: String?) {
    }

    override fun onRtmpConnected(msg: String?) {
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