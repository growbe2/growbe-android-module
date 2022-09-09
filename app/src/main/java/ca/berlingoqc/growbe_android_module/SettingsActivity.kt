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


class SettingsActivity : AppCompatActivity() {

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        validatePermissions()

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        streamingService.initialize(findViewById(R.id.glsurfaceview_camera));

        var intent = Intent(this, GattServerService::class.java)
        startService(intent);

        intent = Intent(this, WebSocketService::class.java)
        startService(intent)

        intent = Intent(this, SensorService::class.java)
        startService(intent)

        intent = Intent(this, PositionService::class.java)
        startService(intent)



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
}