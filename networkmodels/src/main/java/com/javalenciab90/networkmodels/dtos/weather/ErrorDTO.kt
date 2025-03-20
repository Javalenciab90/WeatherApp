package com.javalenciab90.networkmodels.dtos.weather

import com.google.gson.annotations.SerializedName

data class ErrorDTO(
    @SerializedName("code")
    val code: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("info")
    val info: String
)
