package com.javalenciab90.data.datasource.remote.weather

import com.javalenciab90.data.datasource.remote.FetchRemoteData
import com.javalenciab90.data.mappers.WeatherNetworkMapper
import com.javalenciab90.models.openweather.WeatherCurrent
import com.javalenciab90.networkmodels.dtos.openweather.WeatherCurrentDTO
import com.javalenciab90.service.api.WeatherService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRemoteDataImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val weatherNetworkMapper: WeatherNetworkMapper
) : WeatherRemoteData, FetchRemoteData<WeatherCurrentDTO, WeatherCurrent>() {

    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ): Flow<WeatherCurrent> =
        getData(
            apiCall = {
                weatherService.getWeatherData(
                    lat = lat,
                    lon = lon,
                )
            },
            mapper = weatherNetworkMapper
        )
}


