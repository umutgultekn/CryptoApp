package com.umutg.cryptoapp.domain.use_case.get_coin

import com.umutg.cryptoapp.common.Resource
import com.umutg.cryptoapp.data.remote.dto.toCoin
import com.umutg.cryptoapp.domain.model.Coin
import com.umutg.cryptoapp.domain.model.CoinDetail
import com.umutg.cryptoapp.domain.model.toCoinDetail
import com.umutg.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {

            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coins))

        } catch (e: HttpException) {

            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))

        } catch (e: IOException) {

            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}