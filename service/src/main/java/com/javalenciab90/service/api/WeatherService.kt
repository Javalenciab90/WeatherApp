package com.javalenciab90.service.api

import com.javalenciab90.service.config.utils.Params
import com.javalenciab90.data.models.dto.WeatherDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("current")
    suspend fun getMoviesByCategory(
        @Path(Params.QUERY) category: String
    ): WeatherDTO
}

