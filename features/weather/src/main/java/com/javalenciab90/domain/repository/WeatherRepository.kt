package com.javalenciab90.domain.repository

import com.javalenciab90.models.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getCurrentWeather(query: String) : Flow<Weather>
}