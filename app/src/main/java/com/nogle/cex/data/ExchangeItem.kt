package com.nogle.cex.data

/**
 * Created by Ricky on 2023/8/27.
 */
data class BTSEResponse(
    val code: Int,
    val msg: String,
    val time: Long,
    val data: List<ExchangeItem>,
    val success: Boolean
)

data class ExchangeItem(
    val marketName: String,
    val active: Boolean,
    val marketClosed: Boolean,
    val matchingDisabled: Boolean,
    val future: Boolean, // use this to distinguish between spot and futures
    val timeBasedContract: Boolean,
    val openTime: Long,
    val closeTime: Long,
    val startMatching: Long,
    val inactiveTime: Long,
    val sortId: Int,
    val lastUpdate: Long?,
    val symbol: String, // use this to display
    val quoteCurrency: String,
    val baseCurrency: String,
    val fundingRate: Double,
    val openInterest: Int,
    val openInterestUSD: Double,
    val display: Boolean,
    val displayQuote: String?,
    val globalDisplayQuote: String?,
    val displayOrder: Int,
    val isFavorite: Boolean,
    val initialMarginPercentage: Double,
    val maintenanceMarginPercentage: Double,
    val prediction: Boolean,
    val favorite: Boolean,
    var price: Float
)