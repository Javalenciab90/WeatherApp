package com.javalenciab90.domain.repository

import com.javalenciab90.data.datasource.remote.WeatherRemoteData
import com.javalenciab90.models.Weather
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteData: WeatherRemoteData
) : WeatherRepository {

    override suspend fun getCurrentWeather(query: String): Flow<WeatherDTO> = flow {
        weatherRemoteData.getCurrentWeather(query).collect {
            emit(it)
        }
    }
}