package com.nogle.cex.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.nogle.cex.data.ExchangeItem
import com.nogle.cex.network.BTSEApiClient
import com.nogle.cex.network.WebSocketClient
import kotlinx.coroutines.CoroutineScope
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by Ricky on 2023/8/27.
 * two data source
 * Btse http api url get all of coin symbol(exchangeItemList)
 * Btse web socket url get price
 * and filter type = 1 and special symbol from(exchangeItemList)
 * finally update date via live data
 */
class ExchangeRepository : IRepository {
    private val _exchangeData: MutableLiveData<Pair<Map<String, Float>, Map<String, Float>>> = MutableLiveData()
    val exchangeData: LiveData<Pair<Map<String, Float>, Map<String, Float>>> = _exchangeData

    private val exchangeItemList = mutableListOf<ExchangeItem>()

    companion object {
        private const val WSS_URL_BTSE_URL = "wss://ws.btse.com/ws/futures"
        private const val WSS_MESSAGE = "{\"op\": \"subscribe\", \"args\": [\"coinIndex\"]}"
        private const val WSS_KEY_DATA = "data"
        private const val WSS_KEY_TYPE = "type"
        private const val WSS_KEY_ID = "id"
        private const val WSS_KEY_PRICE = "price"
    }

    override suspend fun initializeData(scope: CoroutineScope) {
        WebSocketClient().connect(WSS_URL_BTSE_URL, btseWssListener).send(WSS_MESSAGE)
        processSymbolData()
    }

    private suspend fun processSymbolData() {
        val symbolData = BTSEApiClient.instance.fetchData()
        if (symbolData.isSuccessful) {
            symbolData.body()?.data?.let {
                exchangeItemList.clear()
                exchangeItemList.addAll(it)
            }
        }
    }

    private val btseWssListener = object : WebSocketListener() {
        override fun onMessage(webSocket: WebSocket, text: String) {
            val dataObject = JsonParser.parseString(text).asJsonObject
            priceUpdate(dataObject)
        }
    }

    /**
     * get wss data, and mapping symbol to update price
     */
    private fun priceUpdate(dataObject: JsonObject) {
        dataObject.get(WSS_KEY_DATA)?.let { priceDataObj ->
            val priceObjList: List<JsonObject> = priceDataObj.asJsonObject.entrySet().map { it.value.asJsonObject }
            exchangeItemList.forEach { item ->
                val key = item.symbol
                priceObjList.find {
                    it[WSS_KEY_ID].asString == key &&
                            it[WSS_KEY_TYPE].asInt == 1
                }?.let {
                    item.price = transferTwoDecimalPlaces(it.get(WSS_KEY_PRICE).asFloat)
                }
            }

            val symbolPair = exchangeItemList.partition { !it.future }
            val spotMap = symbolPair.first.associateBy({ it.symbol }, { it.price }).toSortedMap()
            val futureMap = symbolPair.second.associateBy({ it.symbol }, { it.price }).toSortedMap()
            _exchangeData.postValue(Pair(spotMap, futureMap))
        }
    }

    private fun transferTwoDecimalPlaces(number: Float): Float {
        val bigDecimal = BigDecimal(number.toString())
        return bigDecimal.setScale(2, RoundingMode.FLOOR).toFloat()
    }

}

interface IRepository {
    suspend fun initializeData(scope: CoroutineScope)

}