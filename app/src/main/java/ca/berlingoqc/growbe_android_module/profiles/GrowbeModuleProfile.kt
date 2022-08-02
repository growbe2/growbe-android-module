package ca.berlingoqc.growbe_android_module.profiles

import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattService
import java.util.*

object GrowbeModuleProfile {

    val GROWBE_MODULE_SERVICE: UUID = UUID.fromString("373cfe9b-9735-48e6-89e7-199c5f68d47a")

    val MODULE_ID: UUID = UUID.fromString("373cfe9b-9735-48e6-89e7-199c5f68d47b")

    val REGISTER_MAINBOARD_ID: UUID = UUID.fromString("373cfe9b-9735-48e6-89e7-199c5f68d47c")

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
        return "AND0000009"
    }

}