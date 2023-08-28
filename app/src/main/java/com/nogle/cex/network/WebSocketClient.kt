package com.nogle.cex.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

/**
 * Created by Ricky on 2023/8/27.
 * Btse socket path wss://ws.btse.com/ws/futures
 * Btse socket references https://btsecom.github.io/docs/futures/en/#subscription
 */
class WebSocketClient {

    fun connect(socketURL: String,webSocketListener: WebSocketListener):WebSocket {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(socketURL)
            .build()

        return client.newWebSocket(request, webSocketListener)
    }
}