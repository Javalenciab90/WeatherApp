package com.javalenciab90.domain.repository.weather

import android.app.DownloadManager.Query
import com.javalenciab90.data.datasource.local.WeatherLocalData
import com.javalenciab90.data.datasource.remote.weather.WeatherRemoteData
import com.javalenciab90.models.openweather.WeatherCurrent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteData: WeatherRemoteData,
    private val weatherLocalData: WeatherLocalData
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        query: String,
        lat: Double,
        lon: Double
    ): Flow<WeatherCurrent> = flow {
        val localResult = weatherLocalData.getWeatherData(query)
        if (localResult != null) {
            emit(localResult)
        } else {
            weatherRemoteData.getCurrentWeather(lat = lat, lon = lon)
                .collect { remoteResult ->
                    weatherLocalData.insertWeatherData(remoteResult)
                    emit(remoteResult)
                }
        }
    }.flowOn(context = Dispatchers.IO)
}

