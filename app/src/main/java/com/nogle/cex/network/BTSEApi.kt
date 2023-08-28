package com.nogle.cex.network

import com.nogle.cex.data.BTSEResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Ricky on 2023/8/27.
 * BTSE API Interface
 */
interface BTSEApi {
    @GET("futures/api/inquire/initial/market")
    suspend fun fetchData(): Response<BTSEResponse>
}