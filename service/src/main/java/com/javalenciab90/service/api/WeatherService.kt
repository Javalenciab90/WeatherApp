package com.javalenciab90.service.api

import com.javalenciab90.service.config.utils.Params
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("current")
    suspend fun getWeatherData(
        @Query(Params.QUERY) query: String
    ): Response<WeatherDTO>
}

