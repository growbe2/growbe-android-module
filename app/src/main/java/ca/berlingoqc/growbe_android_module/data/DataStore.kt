package ca.berlingoqc.growbe_android_module.data

import ca.berlingoqc.growbe_android_module.proto.Module
import ca.berlingoqc.growbe_android_module.proto.PhoneAmbientLightKt
import ca.berlingoqc.growbe_android_module.proto.PhonePressureKt

class DataStore {

    var position: Module.PhonePosition? = null
        set(value) { field = value; onUpdate() }
    var acceleration: Module.PhoneAcceleration? = null
        set(value) { field = value; onUpdate() }
    var light: Module.PhoneAmbientLight? = null
        set(value) { field = value; onUpdate() }
    var pressure: Module.PhonePressure? = null
        set(value) { field = value; onUpdate() }

    private fun onUpdate() {}

}

public val dataStore = DataStore()