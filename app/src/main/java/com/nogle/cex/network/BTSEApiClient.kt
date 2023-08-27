package com.nogle.cex.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ricky on 2023/8/27.
 */
object BTSEApiClient {
    private const val BASE_URL = "https://api.btse.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .build()

    val instance: BTSEApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(BTSEApi::class.java)
    }
}