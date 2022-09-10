package ca.berlingoqc.growbe_android_module.data

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import ca.berlingoqc.growbe_android_module.proto.Module

class DataStore {

    var positionChanged: () -> Int = { 0 };
    var accelerationChanged: () -> Int = { 0 };
    var lightChanged: () -> Int = { 0 };
    var pressureChanged: () -> Int = { 0 };
    var streamingChanged: () -> Int = { 0 };

    var streamingConfigChanged: () -> Int = { 0 };


    var moduleId: String? = null
        set(value) { field = value; }
    var mainboardId: String? = null
        set(value) { field = value; }

    val supportedModules: Array<String> = arrayOf("PPO", "PAC", "PPR", "PAL", "PCS");

    var position: Module.PhonePositionData? = null
        set(value) { field = value; positionChanged() }
    var acceleration: Module.PhoneAccelerationData? = null
        set(value) { field = value; accelerationChanged() }
    var light: Module.PhoneAmbientLightData? = null
        set(value) { field = value; lightChanged() }
    var pressure: Module.PhonePressureData? = null
        set(value) { field = value; pressureChanged() }
    var streaming: Module.PhoneStreamingData? = null
        set(value) { field = value; streamingChanged() }

    var streamingConfig: Module.PhoneStreamingConfig? = null
        set(value) { field = value; streamingConfigChanged()}


    @SuppressLint("HardwareIds")
    fun initialize(context: Context) {
        moduleId = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        ).substring(0, 9).uppercase()
    }


}

public val dataStore = DataStore()