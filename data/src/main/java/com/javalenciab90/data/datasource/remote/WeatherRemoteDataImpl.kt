package com.javalenciab90.data.datasource.remote

import com.javalenciab90.data.mappers.NetworkMapper
import com.javalenciab90.models.Weather
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import com.javalenciab90.service.api.WeatherService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRemoteDataImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val networkMapper: NetworkMapper
) : WeatherRemoteData, FetchRemoteData<WeatherDTO, Weather>() {

    override suspend fun getCurrentWeather(query: String): Flow<Weather> =
        getData(
            apiCall = { weatherService.getWeatherData(query) },
            mapper = networkMapper
        )

}


