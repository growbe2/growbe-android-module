package ca.berlingoqc.growbe_android_module.data

import ca.berlingoqc.growbe_android_module.proto.Module

class DataStore {

    var position: Module.PhonePositionData? = null
        set(value) { field = value; onUpdate() }
    var acceleration: Module.PhoneAccelerationData? = null
        set(value) { field = value; onUpdate() }
    var light: Module.PhoneAmbientLightData? = null
        set(value) { field = value; onUpdate() }
    var pressure: Module.PhonePressureData? = null
        set(value) { field = value; onUpdate() }

    private fun onUpdate() {}

}

public val dataStore = DataStore()