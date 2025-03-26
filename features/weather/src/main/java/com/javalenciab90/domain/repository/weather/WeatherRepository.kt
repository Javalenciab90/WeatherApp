package com.javalenciab90.domain.repository.weather

import com.javalenciab90.models.openweather.WeatherCurrent
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getCurrentWeather(
        query: String,
        lat: Double,
        lon: Double
    ) : Flow<WeatherCurrent>
}