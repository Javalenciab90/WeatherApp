package com.javalenciab90.networkmodels.dtos.weather

import com.google.gson.annotations.SerializedName

data class RequestDTO(
    @SerializedName("language")
    val language: String,
    @SerializedName("query")
    val query: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String
)