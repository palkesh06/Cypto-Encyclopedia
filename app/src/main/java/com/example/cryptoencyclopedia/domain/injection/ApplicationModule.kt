package com.example.cryptoencyclopedia.domain.injection

import com.example.cryptoencyclopedia.common.Const
import com.example.cryptoencyclopedia.data.remote.CoinPaprikaApi
import com.example.cryptoencyclopedia.data.repository.CoinRepositoryImpl
import com.example.cryptoencyclopedia.domain.repository.CoinRepository
import com.example.cryptoencyclopedia.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptoencyclopedia.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptoencyclopedia.domain.use_case.search_coin.SearchCoinUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)

    @Provides
    fun provideGetCoinsUseCase(repository: CoinRepository) = GetCoinsUseCase(repository)

    @Provides
    fun provideGetCoinUseCase(repository: CoinRepository) = GetCoinUseCase(repository)

    @Provides
    fun provideSearchCoinUseCase(repository: CoinRepository) = SearchCoinUseCase(repository)

}