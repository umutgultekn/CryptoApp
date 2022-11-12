package com.umutg.cryptoapp.data.repository

import com.umutg.cryptoapp.data.remote.CoinPaprikaApi
import com.umutg.cryptoapp.data.remote.dto.CoinDetailDto
import com.umutg.cryptoapp.data.remote.dto.CoinDto
import com.umutg.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}