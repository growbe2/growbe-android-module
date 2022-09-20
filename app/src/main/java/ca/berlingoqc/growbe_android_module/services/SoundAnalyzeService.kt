package ca.berlingoqc.growbe_android_module.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaRecorder
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import java.io.IOException

import android.os.Handler;
import android.os.Looper
import android.util.Log


private const val TAG = "SoundAnalyzeService";


class SoundMeter {
    private var mRecorder: MediaRecorder? = null
    private var mEMA = 0.0

    @RequiresApi(Build.VERSION_CODES.S)
    fun start(context: Context) {
        if (mRecorder == null) {
            mRecorder = MediaRecorder(context)
            mRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
            mRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mRecorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            mRecorder!!.setOutputFile("/dev/null")
            try {
                mRecorder!!.prepare()
                Thread.sleep(1000);
                mRecorder!!.start()
            } catch (e: java.lang.IllegalStateException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            mEMA = 0.0
        }
    }

    fun stop() {
        if (mRecorder != null) {
            mRecorder!!.stop()
            mRecorder!!.release()
            mRecorder = null
        }
    }

    val amplitude: Double
        get() = if (mRecorder != null) mRecorder!!.maxAmplitude / 2700.0 else 0.0

    val amplitudeEMA: Double
        get() {
            val amp = amplitude
            mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA
            return mEMA
        }

    companion object {
        // This file is used to record voice
        private const val EMA_FILTER = 0.6
    }
}

class SoundAnalyzeService : Service() {

    private val soundMeter = SoundMeter();

    private val handler = Handler(Looper.myLooper()!!);

    private val runnable = object: Runnable {
        override fun run() {
            Log.d(TAG, "periodically ${soundMeter.amplitude}");
            handler.postDelayed(this, 2000);
        }

    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        soundMeter.start(this);
        handler.post(runnable);

        return START_STICKY;
    }
}