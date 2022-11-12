package com.umutg.cryptoapp.domain.repository

import com.umutg.cryptoapp.data.remote.dto.CoinDetailDto
import com.umutg.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}