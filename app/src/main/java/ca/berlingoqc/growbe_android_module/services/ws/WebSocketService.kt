package ca.berlingoqc.growbe_android_module.services.ws

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import ca.berlingoqc.growbe_android_module.data.dataStore
import ca.berlingoqc.growbe_android_module.services.gatt.profiles.GrowbeModuleProfile
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

data class WebSocketMessage(val topic: String, val payload: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WebSocketMessage

        if (topic != other.topic) return false
        if (!payload.contentEquals(other.payload)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = topic.hashCode()
        result = 31 * result + payload.contentHashCode()
        return result
    }

    fun toJSONString(): String {
        return """{"topic": "$topic", "payload": "${String(payload)}"}"""
    }
};


val regexMessage = Regex("""\{\"topic\": \"(.*)\", \"payload\": \"(.*)\"\}""")

fun parseWebSocketMessage(msg: String): WebSocketMessage? {
    val matches = regexMessage.find(msg);
    if (matches != null && matches.groupValues.size == 3) {
       return WebSocketMessage(matches.groupValues[1], matches.groupValues[2].toByteArray());
    }
    return null;
}

fun WebSocket.sendMessage(topic: String, data: String) {
    return this.sendMessage(topic, data.toByteArray());
}

fun WebSocket.sendMessage(topic: String, data: ByteArray) {
    val msg = WebSocketMessage(topic, data);
    this.send(msg.toJSONString());
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