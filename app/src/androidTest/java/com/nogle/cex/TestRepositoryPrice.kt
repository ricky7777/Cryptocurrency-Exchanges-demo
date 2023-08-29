package com.nogle.cex

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonParser
import com.nogle.cex.data.ExchangeItem
import com.nogle.cex.repository.ExchangeRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import java.util.SortedMap

/**
 * Created by Ricky on 2023/8/29.
 * unit test
 */
class TestRepositoryPrice {
    private val exchangeItemList = mutableListOf<ExchangeItem>()

    private val mockSpotMap = sortedMapOf(
        "BTC" to 60000.0f,
        "ETH" to 3000.0f
    )

    private val mockFutureMap = sortedMapOf(
        "BTC_FUT" to 51000.0f,
        "ETH_FUT" to 2550.0f
    )

    private val _exchangeData = MutableLiveData<Pair<SortedMap<String, Float>, SortedMap<String, Float>>>()

    private val exchangeItemBTC = ExchangeItem(
        "BTC/USD", active = true, marketClosed = false,
        matchingDisabled = false, future = false, timeBasedContract = false, openTime = 0L, closeTime = 0L,
        startMatching = 0L, inactiveTime = 0L, sortId = 1, lastUpdate = null, symbol = "BTC", quoteCurrency = "USD",
        baseCurrency = "BTC", fundingRate = 0.0, openInterest = 0, openInterestUSD = 0.0, display = true,
        displayQuote = null, globalDisplayQuote = null, displayOrder = 0, isFavorite = false,
        initialMarginPercentage = 0.0, maintenanceMarginPercentage = 0.0, prediction = false,
        favorite = false, price = 0.0f
    )

    private val exchangeItemETH = ExchangeItem(
        "ETH/USD", active = true, marketClosed = false, matchingDisabled = false, future = false,
        timeBasedContract = false, openTime = 0L, closeTime = 0L, startMatching = 0L, inactiveTime = 0L,
        sortId = 2, lastUpdate = null, symbol = "ETH", quoteCurrency = "USD", baseCurrency = "ETH",
        fundingRate = 0.0, openInterest = 0, openInterestUSD = 0.0, display = true,
        displayQuote = null, globalDisplayQuote = null, displayOrder = 0, isFavorite = false,
        initialMarginPercentage = 0.0, maintenanceMarginPercentage = 0.0, prediction = false,
        favorite = false, price = 0.0f
    )

    private val mockDataJson = """
        {
            "${ExchangeRepository.WSS_KEY_DATA}": {
                "BTC": {
                    "${ExchangeRepository.WSS_KEY_ID}": "BTC",
                    "${ExchangeRepository.WSS_KEY_ID}": 1,
                    "${ExchangeRepository.WSS_KEY_PRICE}": 0
                },
                "ETH": {
                    "${ExchangeRepository.WSS_KEY_ID}": "ETH",
                    "${ExchangeRepository.WSS_KEY_ID}": 1,
                    "${ExchangeRepository.WSS_KEY_PRICE}": 0
                }
            }
        }
        """

    @Test
    fun testPriceUpdate() {
        _exchangeData.postValue(Pair(mockSpotMap, mockFutureMap))

        val dataObject = JsonParser.parseString(mockDataJson).asJsonObject

        // 初始化 exchangeItemList
        exchangeItemList.add(exchangeItemBTC)
        exchangeItemList.add(exchangeItemETH)

        val exchangeRepository = ExchangeRepository()
        exchangeRepository.priceUpdate(dataObject)

        // Step 3: 驗證結果
        val expectedSpotMap = sortedMapOf("BTC" to 60000.0f, "ETH" to 3000.0f)
        val expectedFutureMap = sortedMapOf("BTC_FUT" to 51000.0f, "ETH_FUT" to 2550.0f)

        val result = _exchangeData.value

        assertNotNull(result)  // 確保 _exchangeData 有資料
        assertEquals(expectedSpotMap, result?.first)
        assertEquals(expectedFutureMap, result?.second)
    }


}