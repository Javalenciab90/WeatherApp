package com.javalenciab90.data.room.entities

import com.javalenciab90.models.openweather.Location

data class LocationEntity(
    val lat: Double,
    val lon: Double
) {
    fun toModel() : Location =
        Location(
            lat = lat,
            lon = lon
        )
}