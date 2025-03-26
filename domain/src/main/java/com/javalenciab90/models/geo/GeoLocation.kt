package com.javalenciab90.models.geo

data class GeoLocation(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String?
)