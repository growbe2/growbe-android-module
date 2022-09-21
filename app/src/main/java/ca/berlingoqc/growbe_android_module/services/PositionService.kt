package ca.berlingoqc.growbe_android_module.services

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.location.Location
import android.os.IBinder
import android.os.Looper
import android.util.Log
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.proto.Module
import com.google.android.gms.location.*


private const val TAG = "GattServerActivity"

class PositionService : Service() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        locationCallback = object: LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                val lastLocation = p0.lastLocation ?: return

                dataStore.position = Module.PhonePositionData.newBuilder()
                    .setAccuracy(lastLocation.accuracy)
                    .setAltitude(lastLocation.altitude)
                    .setBearing(lastLocation.bearing)
                    .setSpeed(lastLocation.speed)
                    .setLat(lastLocation.latitude.toFloat())
                    .setLog(lastLocation.longitude.toFloat())
                    .build()
            }
        }

        val request = LocationRequest.create();
        request.interval = 1000;
        fusedLocationClient.requestLocationUpdates(request, locationCallback, Looper.myLooper())

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


    private fun requestNewLocationData() {

    }
}