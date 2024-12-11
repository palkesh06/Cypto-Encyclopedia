package com.example.cryptoencyclopedia.presentation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_details_screen")
    object CoinSearchScreen: Screen("coin_search_screen")
}