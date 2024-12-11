package com.example.cryptoencyclopedia.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.cryptoencyclopedia.data.remote.dto.CoinDetailDto
import com.example.cryptoencyclopedia.data.remote.dto.CoinDto
import com.example.cryptoencyclopedia.data.remote.dto.CoinSearchResultDto
import retrofit2.http.Query


interface CoinPaprikaApi {

    @GET("/v1/search/")
    suspend fun searchCoins(@Query("q") query: String): CoinSearchResultDto

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoin(@Path("coin_id") coinId: String): CoinDetailDto
}