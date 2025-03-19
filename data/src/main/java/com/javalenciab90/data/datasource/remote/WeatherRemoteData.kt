package com.javalenciab90.data.datasource.remote

import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import kotlinx.coroutines.flow.Flow

interface WeatherRemoteData {
    suspend fun getCurrentWeather(query: String) : Flow<WeatherDTO>
}