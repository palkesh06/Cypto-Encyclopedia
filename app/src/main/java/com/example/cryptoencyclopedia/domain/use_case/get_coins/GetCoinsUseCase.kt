package com.example.cryptoencyclopedia.domain.use_case.get_coins

import com.example.cryptoencyclopedia.common.Resource
import com.example.cryptoencyclopedia.data.remote.dto.toCoin
import com.example.cryptoencyclopedia.domain.model.CoinModel
import com.example.cryptoencyclopedia.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoinsUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinModel>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map{it.toCoin()}
            emit(Resource.Success(coins))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}