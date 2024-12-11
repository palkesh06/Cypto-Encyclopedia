package com.example.cryptoencyclopedia.data.repository

import com.example.cryptoencyclopedia.data.remote.CoinPaprikaApi
import com.example.cryptoencyclopedia.data.remote.dto.CoinDetailDto
import com.example.cryptoencyclopedia.data.remote.dto.CoinDto
import com.example.cryptoencyclopedia.data.remote.dto.CoinSearchResultDto
import com.example.cryptoencyclopedia.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinRepositoryImpl(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return withContext(Dispatchers.IO){
            api.getCoins()
        }
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return withContext(Dispatchers.IO){
            api.getCoin(coinId)
        }
    }

    override suspend fun searchCoins(query: String): CoinSearchResultDto {
        return withContext(Dispatchers.IO){
            api.searchCoins(query)
        }
    }
}