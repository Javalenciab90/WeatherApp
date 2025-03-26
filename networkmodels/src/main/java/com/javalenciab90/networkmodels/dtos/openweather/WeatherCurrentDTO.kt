package com.javalenciab90.networkmodels.dtos.openweather

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDTO(
    @SerializedName("cod")
    val cod: Int,
    @SerializedName("coord")
    val location: LocationDTO,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: MainDTO,
    @SerializedName("name")
    val name: String,
    @SerializedName("weather")
    val weather: List<WeatherDTO>
)