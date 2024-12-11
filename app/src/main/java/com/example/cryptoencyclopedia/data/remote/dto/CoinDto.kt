package com.example.cryptoencyclopedia.data.remote.dto

import com.example.cryptoencyclopedia.domain.model.CoinModel
import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id") val id: String,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("type") val type: String
)

fun CoinDto.toCoin(): CoinModel {
    return CoinModel(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}