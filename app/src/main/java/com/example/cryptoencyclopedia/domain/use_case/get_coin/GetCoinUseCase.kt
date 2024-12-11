package com.example.cryptoencyclopedia.domain.use_case.get_coin

import com.example.cryptoencyclopedia.common.Resource
import com.example.cryptoencyclopedia.data.remote.dto.toCoinDetail
import com.example.cryptoencyclopedia.domain.model.CoinDetailModel
import com.example.cryptoencyclopedia.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoinUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String): Flow<Resource<CoinDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(id).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}