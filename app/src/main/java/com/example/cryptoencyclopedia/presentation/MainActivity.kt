package com.example.cryptoencyclopedia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoencyclopedia.common.Const
import com.example.cryptoencyclopedia.presentation.coin_detail.components.CoinDetailScreen
import com.example.cryptoencyclopedia.presentation.coin_list.component.CoinListScreen
import com.example.cryptoencyclopedia.presentation.coin_search.component.CoinSearchScreen
import com.example.cryptoencyclopedia.presentation.ui.theme.CryptoEncyclopediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoEncyclopediaTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.CoinListScreen.route) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{${Const.PARAM_COIN_ID}}") {
                            CoinDetailScreen(navController)
                        }
                        composable(route = Screen.CoinSearchScreen.route) {
                            CoinSearchScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

