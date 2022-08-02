package ca.berlingoqc.growbe_android_module.services

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.location.Location
import android.os.IBinder
import android.util.Log

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;



private const val TAG = "GattServerActivity"

class PositionService : Service() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                Log.i(TAG, "Location $location")
            }


        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


    private fun requestNewLocationData() {

    }
}