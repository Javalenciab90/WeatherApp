package com.javalenciab90.data.datasource.remote.weather

import com.javalenciab90.models.openweather.WeatherCurrent
import kotlinx.coroutines.flow.Flow

interface WeatherRemoteData {
    suspend fun getCurrentWeather(lat: Double, lon: Double) : Flow<WeatherCurrent>
}