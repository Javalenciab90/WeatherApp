package com.javalenciab90.networkmodels.dtos.geo

import com.google.gson.annotations.SerializedName

class GeoLocationListDTO : ArrayList<GeoLocationDTO>()

data class GeoLocationDTO(
    @SerializedName("country")
    val country: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("state")
    val state: String?
)

