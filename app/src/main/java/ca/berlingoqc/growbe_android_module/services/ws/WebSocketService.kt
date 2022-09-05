package ca.berlingoqc.growbe_android_module.services.ws

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.services.gatt.profiles.GrowbeModuleProfile
import com.google.gson.Gson
import com.koushikdutta.async.AsyncServer
import com.koushikdutta.async.http.server.AsyncHttpServer
import com.koushikdutta.async.callback.CompletedCallback
import com.koushikdutta.async.http.WebSocket
import com.koushikdutta.async.http.server.AsyncHttpServer.WebSocketRequestCallback

import com.koushikdutta.async.http.server.AsyncHttpServerRequest

private const val TAG = "WebSocketService"

const val MSG_READ_SUPPORTED_MODULES = "READ_SUPPORTED_MODULES";
const val MSG_READ_MODULE_ID = "READ_MODULE_ID";
const val MSG_READ_LIGHT = "READ_LIGHT";
const val MSG_READ_POSITION = "READ_POSITION";
const val MSG_READ_ACCELERATION = "READ_ACCELERATION";
const val MSG_READ_PRESSURE = "READ_PRESSURE";

data class WebSocketMessage(val topic: String, val payload: String) {
    fun toJSONString(): String {
        val gson = Gson();
        return gson.toJson(this);
    }
};


fun parseWebSocketMessage(msg: String): WebSocketMessage? {
    val gson = Gson();
    return gson.fromJson(msg, WebSocketMessage::class.java);
}

fun WebSocket.sendMessage(topic: String, data: String) {
    val msg = WebSocketMessage(topic, data);
    this.send(msg.toJSONString());
}

fun WebSocket.sendMessage(topic: String, data: ByteArray) {
    return this.sendMessage(topic, String(data));
}

class WebSocketService : Service() {


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val httpServer = AsyncHttpServer();
        var socket: WebSocket? = null;

        httpServer.listen(AsyncServer.getDefault(), 5000);

        Log.i(TAG, "starting ${AsyncServer.getDefault()} 5000")

        httpServer.websocket(
            "/live"
        ) { webSocket, request ->
            if (socket == null) {
                print("Sending for first time");
                webSocket.sendMessage(MSG_READ_MODULE_ID, GrowbeModuleProfile.getId());
                webSocket.sendMessage(MSG_READ_SUPPORTED_MODULES, GrowbeModuleProfile.getSupportedModule().joinToString(";"));
            }
            socket = webSocket;

            //Use this to clean up any references to your websocket
            webSocket.closedCallback = CompletedCallback { ex ->
                try {
                    if (ex != null) Log.e(TAG, "An error occurred", ex)
                } finally {
                    socket = null;
                }
            }

            webSocket.setStringCallback { ex ->
                val msg = parseWebSocketMessage(ex);
                Log.e(TAG, "$msg");
                if (msg != null) {
                    when(msg.topic) {
                        MSG_READ_MODULE_ID -> {
                            webSocket.sendMessage(MSG_READ_MODULE_ID, GrowbeModuleProfile.getId());
                        }
                        MSG_READ_SUPPORTED_MODULES -> {
                            webSocket.sendMessage(MSG_READ_SUPPORTED_MODULES, GrowbeModuleProfile.getSupportedModule().joinToString(";"));
                        }
                        MSG_READ_ACCELERATION -> {
                            webSocket.sendMessage(MSG_READ_ACCELERATION, dataStore.acceleration?.toByteArray()!!)
                        }
                        MSG_READ_LIGHT -> {
                            webSocket.sendMessage(MSG_READ_LIGHT, dataStore.light?.toByteArray()!!);
                        }
                        MSG_READ_POSITION -> {
                            webSocket.sendMessage(MSG_READ_POSITION, dataStore.position?.toByteArray()!!);
                        }
                        MSG_READ_PRESSURE -> {
                            webSocket.sendMessage(MSG_READ_PRESSURE, dataStore.pressure?.toByteArray()!!);
                        }
                        else -> {
                            Log.w(TAG, "failed to get topic ${msg.topic}");
                        }
                    }
                }
            }
        }

        return START_STICKY;
    }
}