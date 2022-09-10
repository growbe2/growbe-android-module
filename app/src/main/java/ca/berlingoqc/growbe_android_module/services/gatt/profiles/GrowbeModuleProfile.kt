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
import ca.berlingoqc.growbe_android_module.data.dataStore


object GrowbeModuleProfile {

    val GROWBE_MODULE_SERVICE: UUID = UUID.fromString("00000000-0000-0000-000f-eedc0de00002")

    val MODULES_SUPPORTED_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000000")

    val MODULE_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000002")

    val REGISTER_MAINBOARD_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000002")

    val POSITION_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000003")

    val ACCELERATION_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff0000004")

    val LIGHT_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000005")

    val PRESSURE_ID: UUID = UUID.fromString("00000000-0000-0000-0000-ffff00000006")

    fun createGrowbeModuleService(): BluetoothGattService {

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
        return dataStore.moduleId!!;
    }

    fun getSupportedModule(): Array<String> {
        return dataStore.supportedModules;
    }

    fun getLinkMainboardId(): String {
       return dataStore.mainboardId!!;
    }
}