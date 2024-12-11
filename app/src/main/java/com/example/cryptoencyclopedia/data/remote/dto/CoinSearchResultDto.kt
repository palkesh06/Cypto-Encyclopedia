package com.example.cryptoencyclopedia.data.remote.dto

import com.example.cryptoencyclopedia.domain.model.CurrencyModel
import com.google.gson.annotations.SerializedName

data class CoinSearchResultDto(
    @SerializedName("currencies") val currencies: List<Currency>
)

fun CoinSearchResultDto.toCurrencyModel(): List<CurrencyModel> {
    val result = mutableListOf<CurrencyModel>()
    for (currency in this.currencies) {
        result.add(
            CurrencyModel(
                id = currency.id,
                isActive = currency.isActive,
                name = currency.name,
                rank = currency.rank,
                symbol = currency.symbol
            )
        )
    }
    return result
}
