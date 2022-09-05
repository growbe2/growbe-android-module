package ca.berlingoqc.growbe_android_module.data

import ca.berlingoqc.growbe_android_module.proto.Module

class DataStore {

    var positionChanged: () -> Int = { 0 };
    var accelerationChanged: () -> Int = { 0 };
    var lightChanged: () -> Int = { 0 };
    var pressureChanged: () -> Int = { 0 };

    var position: Module.PhonePositionData? = null
        set(value) { field = value; positionChanged() }
    var acceleration: Module.PhoneAccelerationData? = null
        set(value) { field = value; accelerationChanged() }
    var light: Module.PhoneAmbientLightData? = null
        set(value) { field = value; lightChanged() }
    var pressure: Module.PhonePressureData? = null
        set(value) { field = value; pressureChanged() }
}

public val dataStore = DataStore()