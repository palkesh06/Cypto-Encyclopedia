package com.example.cryptoencyclopedia.presentation.coin_list

import com.example.cryptoencyclopedia.domain.model.CoinModel

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinModel> = emptyList(),
    val error: String = ""
)