package com.javalenciab90.networkmodels.dtos.openweather

import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val iconId: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)