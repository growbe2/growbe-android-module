package ca.berlingoqc.growbe_android_module.services

import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.util.Log
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.proto.Module

private const val TAG = "SensorService"

class SensorService : Service() , SensorEventListener {
    private val requestedSensors = arrayOf(
        Sensor.TYPE_ACCELEROMETER,
        Sensor.TYPE_LIGHT,
        Sensor.TYPE_PRESSURE,
        Sensor.TYPE_AMBIENT_TEMPERATURE,
        Sensor.TYPE_RELATIVE_HUMIDITY,
    )
    private lateinit var sensorManager: SensorManager

    private var sensors: Array<Sensor> = arrayOf()

    // SERVICE

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Starting sensor service")

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        for (requestedSensor in requestedSensors) {
            sensorManager.getDefaultSensor(requestedSensor).let {
                if (it != null) {
                    sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
                    sensors = sensors.plus(it)
                } else {
                    Log.w(TAG, "Sensor not available $requestedSensor")
                }
            }
        }

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    // SENSOR EVENT LISTENER

    override fun onSensorChanged(p0: SensorEvent?) {
        when {
            p0?.sensor?.type == Sensor.TYPE_ACCELEROMETER -> {
                if (
                   is_different_of(dataStore.acceleration?.gx ?: 0f, p0.values[0], 0.05f) ||
                   is_different_of(dataStore.acceleration?.gy ?: 0f, p0.values[1], 0.05f) ||
                   is_different_of(dataStore.acceleration?.gz ?: 0f, p0.values[2], 0.05f)
                ) {
                    dataStore.acceleration = Module.PhoneAccelerationData.newBuilder()
                        .setGx(p0.values[0])
                        .setGy(p0.values[1])
                        .setGz(p0.values[2])
                        .build()
                }
            }
            p0?.sensor?.type == Sensor.TYPE_LIGHT -> {
                dataStore.light = Module.PhoneAmbientLightData.newBuilder()
                    .setSiLux(p0.values[0])
                    .build()
            }
            p0?.sensor?.type == Sensor.TYPE_PRESSURE -> {
                if (is_different_of(dataStore.pressure?.hpa ?: 0f, p0.values[0], 0.03f)) {
                    dataStore.pressure = Module.PhonePressureData.newBuilder()
                        .setHpa(p0.values[0])
                        .build()
                }
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.i(TAG, "Sensor accuracy changed $p0 $p1")
    }

    private fun is_different_of(past_value: Float, value: Float, diff: Float): Boolean {
        return (past_value - diff) >= value || (past_value + diff) <= value
    }
}