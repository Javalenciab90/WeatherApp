package com.javalenciab90.networkmodels.dtos.weather

import com.google.gson.annotations.SerializedName

data class LocationDTO(
    @SerializedName("country")
    val country: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("localtime")
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    @SerializedName("lon")
    val lon: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("timezone_id")
    val timezoneId: String,
    @SerializedName("utc_offset")
    val utcOffset: String
)