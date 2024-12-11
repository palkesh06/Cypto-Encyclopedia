package com.example.cryptoencyclopedia.domain.use_case.search_coin

import com.example.cryptoencyclopedia.common.Resource
import com.example.cryptoencyclopedia.data.remote.dto.toCurrencyModel
import com.example.cryptoencyclopedia.domain.model.CurrencyModel
import com.example.cryptoencyclopedia.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchCoinUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<CurrencyModel>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.searchCoins(query).toCurrencyModel()
            emit(Resource.Success(coins))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}