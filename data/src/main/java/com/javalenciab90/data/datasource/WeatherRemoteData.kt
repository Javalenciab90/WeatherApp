package com.javalenciab90.data.datasource

import com.javalenciab90.data.models.dto.WeatherDTO
import kotlinx.coroutines.flow.Flow

interface WeatherRemoteData {
    suspend fun getCurrentWeather(query: String) : Flow<WeatherDTO>
}