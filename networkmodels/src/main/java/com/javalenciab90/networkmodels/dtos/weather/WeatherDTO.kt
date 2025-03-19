package com.javalenciab90.networkmodels.dtos.weather

import com.google.gson.annotations.SerializedName

data class WeatherDTO(

    @SerializedName("request")
    val request: RequestDTO?,
    @SerializedName("location")
    val location: LocationDTO?,
    @SerializedName("current")
    val current: CurrentDTO?,
    @SerializedName("error")
    val error: ErrorDTO?
)