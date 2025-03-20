package com.javalenciab90.domain.repository

import com.javalenciab90.data.datasource.local.WeatherLocalData
import com.javalenciab90.data.datasource.remote.WeatherRemoteData
import com.javalenciab90.models.Weather
import com.javalenciab90.plataform.base.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteData: WeatherRemoteData,
    private val weatherLocalData: WeatherLocalData
) : WeatherRepository {

    override suspend fun getCurrentWeather(query: String): Flow<Weather> = flow {
        val localResult = weatherLocalData.getWeatherData()
        if (localResult != null) {
            emit(localResult)
        } else {
            weatherRemoteData.getCurrentWeather(query).collect { remoteResult ->
                weatherLocalData.insertWeatherData(remoteResult)
                emit(remoteResult)
            }
        }
    }.flowOn(context = Dispatchers.IO)
}

