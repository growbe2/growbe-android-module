package ca.berlingoqc.growbe_android_module

import android.Manifest
import android.content.Intent
import android.content.pm.ModuleInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.core.app.ActivityCompat
import ca.berlingoqc.growbe_android_module.proto.Module
import ca.berlingoqc.growbe_android_module.services.PositionService
import ca.berlingoqc.growbe_android_module.services.SensorService
import ca.berlingoqc.growbe_android_module.services.gatt.GattServerService
import ca.berlingoqc.growbe_android_module.services.ws.WebSocketService


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.settings, SettingsFragment())
                    .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        validatePermissions()

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