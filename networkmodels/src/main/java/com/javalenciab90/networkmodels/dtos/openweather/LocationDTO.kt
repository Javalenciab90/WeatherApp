package com.javalenciab90.networkmodels.dtos.openweather

import com.google.gson.annotations.SerializedName

data class LocationDTO(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)