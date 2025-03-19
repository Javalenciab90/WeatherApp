package com.javalenciab90.data.datasource.remote

import com.javalenciab90.models.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRemoteData {
    suspend fun getCurrentWeather(query: String) : Flow<Weather>
}