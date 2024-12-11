package com.example.cryptoencyclopedia.presentation.coin_search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoencyclopedia.common.Resource
import com.example.cryptoencyclopedia.domain.use_case.search_coin.SearchCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinSearchViewModel @Inject constructor(
    private val searchCoinUseCase: SearchCoinUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinSearchState())
    val state: State<CoinSearchState> = _state

    private var lastSearchQuery: String = ""
    fun onSearchQueryChanged(query: String) {
        if (query != lastSearchQuery) {
            searchCoinUseCase.invoke(query).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinSearchState(coins = result.data ?: emptyList())
                        lastSearchQuery = query
                    }

                    is Resource.Error -> {
                        _state.value = CoinSearchState(error = "Please your check query and try again")
                    }

                    is Resource.Loading -> {
                        _state.value = CoinSearchState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }
}