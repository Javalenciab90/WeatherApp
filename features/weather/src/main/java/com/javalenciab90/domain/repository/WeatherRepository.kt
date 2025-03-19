package com.javalenciab90.domain.repository

import com.javalenciab90.models.Weather
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getCurrentWeather(query: String) : Flow<WeatherDTO>
}