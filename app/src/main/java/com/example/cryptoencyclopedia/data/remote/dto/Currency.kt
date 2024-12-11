package com.example.cryptoencyclopedia.data.remote.dto

import com.google.gson.annotations.SerializedName


data class Currency(
    @SerializedName("id") val id: String,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("rev") val rev: Int,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("type") val type: String
)

