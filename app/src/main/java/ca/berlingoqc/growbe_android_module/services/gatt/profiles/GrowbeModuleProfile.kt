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
import android.util.Log
import androidx.preference.PreferenceManager


object GrowbeModuleProfile {

    val GROWBE_MODULE_SERVICE: UUID = UUID.fromString("00000000-0000-0000-000f-eedc0de00002")

    val MODULES_SUPPORTED_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000000")

    val MODULE_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000002")

    val REGISTER_MAINBOARD_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000002")

    val POSITION_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000003")

    val ACCELERATION_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff0000004")

    val LIGHT_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000005")

    val PRESSURE_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000006")

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

        Log.e("GrowbeModuleProfile", "$androidId")

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

        val supportedModulesId = BluetoothGattCharacteristic(
            MODULES_SUPPORTED_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            BluetoothGattCharacteristic.PERMISSION_READ
        )

        val registerMainboardId = BluetoothGattCharacteristic(
            REGISTER_MAINBOARD_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_WRITE,
            BluetoothGattCharacteristic.PERMISSION_WRITE or BluetoothGattCharacteristic.PERMISSION_READ
        )

        val positionId = BluetoothGattCharacteristic(
            POSITION_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            BluetoothGattCharacteristic.PERMISSION_READ
        )

        val accelerationId = BluetoothGattCharacteristic(
            ACCELERATION_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            BluetoothGattCharacteristic.PERMISSION_READ
        )

        val pressureId = BluetoothGattCharacteristic(
            PRESSURE_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            BluetoothGattCharacteristic.PERMISSION_READ
        )

        val lightId = BluetoothGattCharacteristic(
            LIGHT_ID,
            BluetoothGattCharacteristic.PROPERTY_READ or BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            BluetoothGattCharacteristic.PERMISSION_READ
        )

        service.addCharacteristic(moduleId)
        service.addCharacteristic(supportedModulesId)
        service.addCharacteristic(registerMainboardId)
        service.addCharacteristic(positionId)
        service.addCharacteristic(accelerationId)
        service.addCharacteristic(pressureId)
        service.addCharacteristic(lightId)

        return service
    }

    fun getId(): String {
        return "$androidId"
    }

    fun getSupportedModule(): Array<String> {
        return arrayOf("PPO", "PAC", "PPR", "PAL")
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