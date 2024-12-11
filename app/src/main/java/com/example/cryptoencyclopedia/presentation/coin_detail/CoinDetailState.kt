package com.example.cryptoencyclopedia.presentation.coin_detail

import com.example.cryptoencyclopedia.domain.model.CoinDetailModel

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetailModel? = null,
    val error: String = ""
)
