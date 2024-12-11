package com.example.cryptoencyclopedia.domain.model

data class CurrencyModel(
    val id: String = "",
    val isActive: Boolean = false,
    val name: String = "",
    val rank: Int = 0,
    val symbol: String = "",
)