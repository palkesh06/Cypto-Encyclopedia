package com.example.cryptoencyclopedia.presentation.coin_search


import com.example.cryptoencyclopedia.domain.model.CurrencyModel

data class CoinSearchState(
    val isLoading: Boolean = false,
    val coins: List<CurrencyModel> = emptyList<CurrencyModel>(),
    val error: String = ""
)