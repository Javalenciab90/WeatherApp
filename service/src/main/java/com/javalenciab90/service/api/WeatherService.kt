package com.javalenciab90.service.api

import com.javalenciab90.networkmodels.dtos.geo.GeoLocationListDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherCurrentDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        const val URL_GET_CURRENT_WEATHER = "data/2.5/weather"
        const val URL_GET_GEO_DIRECT = "geo/1.0/direct"
        const val URL_GET_GEO_REVERSE = "geo/1.0/reverse"
    }

    object Params {
        const val QUERY = "q"
        const val LATITUDE = "lat"
        const val LONGITUDE = "lon"
        const val EXCLUDE = "exclude"
        const val LIMIT = "limit"
        const val UNITS = "units"
    }

    @GET(URL_GET_CURRENT_WEATHER)
    suspend fun getWeatherData(
        @Query(Params.LATITUDE) lat: Double,
        @Query(Params.LONGITUDE) lon: Double,
        @Query(Params.EXCLUDE) exclude: String = "minutely,hourly,daily,alerts",
        @Query(Params.UNITS) units: String = "metric"
    ): Response<WeatherCurrentDTO>

    @GET(URL_GET_GEO_DIRECT)
    suspend fun getGeoLocationData(
        @Query(Params.QUERY) q: String,
        @Query(Params.LIMIT) limit: Int = 1
    ) : Response<GeoLocationListDTO>

    @GET(URL_GET_GEO_REVERSE)
    suspend fun getNameLocationData(
        @Query(Params.LATITUDE) lat: Double,
        @Query(Params.LONGITUDE) lon: Double,
        @Query(Params.LIMIT) limit: Int = 1
    ) : Response<GeoLocationListDTO>
}

