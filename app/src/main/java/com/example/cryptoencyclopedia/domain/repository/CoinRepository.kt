package com.example.cryptoencyclopedia.domain.repository

import com.example.cryptoencyclopedia.data.remote.dto.CoinDetailDto
import com.example.cryptoencyclopedia.data.remote.dto.CoinDto
import com.example.cryptoencyclopedia.data.remote.dto.CoinSearchResultDto


interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(coinId: String): CoinDetailDto

    suspend fun searchCoins(query: String): CoinSearchResultDto
}