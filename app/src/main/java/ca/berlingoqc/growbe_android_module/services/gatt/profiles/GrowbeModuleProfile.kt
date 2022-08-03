package ca.berlingoqc.growbe_android_module.services.gatt.profiles

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattService
import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import java.util.*
import android.provider.Settings.Secure
import android.provider.Settings.Secure.ANDROID_ID
import androidx.preference.PreferenceManager


object GrowbeModuleProfile {

    val GROWBE_MODULE_SERVICE: UUID = UUID.fromString("373cfe9b-9735-48e6-89e7-199c5f68d47a")

    val MODULE_ID: UUID = UUID.fromString("373cfe9b-9735-48e6-89e7-199c5f68d47b")

    val REGISTER_MAINBOARD_ID: UUID = UUID.fromString("373cfe9b-9735-48e6-89e7-199c5f68d47c")

    val MAINBOARD_ID_KEY_PREFERENCE: String = "ca.berlingoqc.growbe_android_module.mainboardId"

    var sharedPreferences: SharedPreferences? = null

    var androidId: String = ""

    var mainboardId: String = ""

    @SuppressLint("HardwareIds")
    fun createGrowbeModuleService(context: Context): BluetoothGattService {

        androidId = Secure.getString(
            context.contentResolver,
            ANDROID_ID
        ).substring(0, 9).uppercase()

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

        mainboardId = sharedPreferences?.getString(MAINBOARD_ID_KEY_PREFERENCE, "").toString()

        val service = BluetoothGattService(
            GROWBE_MODULE_SERVICE,
            BluetoothGattService.SERVICE_TYPE_PRIMARY
        )

        val moduleId = BluetoothGattCharacteristic(
            MODULE_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            BluetoothGattCharacteristic.PERMISSION_READ
        )

        val registerMainboardId = BluetoothGattCharacteristic(
            REGISTER_MAINBOARD_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_WRITE,
            BluetoothGattCharacteristic.PERMISSION_WRITE or BluetoothGattCharacteristic.PERMISSION_READ
        )

        service.addCharacteristic(moduleId)
        service.addCharacteristic(registerMainboardId)

        return service
    }

    fun getModuleId(): String {
        return "AND$androidId"
    }

    fun getLinkMainboardId(): String {
       return mainboardId
    }

    fun setLinkMainboardId(mainboardId: String) {
        sharedPreferences?.edit().let {
            it?.putString(MAINBOARD_ID_KEY_PREFERENCE, mainboardId)
            this.mainboardId = mainboardId
            it?.commit()
        }
    }

}