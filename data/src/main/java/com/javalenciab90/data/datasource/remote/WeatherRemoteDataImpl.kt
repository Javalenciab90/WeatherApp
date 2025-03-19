package com.javalenciab90.data.datasource.remote

import android.util.Log
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import com.javalenciab90.service.api.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRemoteDataImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherRemoteData {

    override suspend fun getCurrentWeather(query: String): Flow<WeatherDTO> = flow {
        try {
            val response = weatherService.getWeatherData(query)
            if (response.isSuccessful) {
                emit(response.body() ?: throw RuntimeException("response body is null"))
            } else {
                response.body()?.let {
                    throw RuntimeException("${response.code()}")
                } ?: throw RuntimeException("Unexpected error: ${response.message()}")
            }
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}


