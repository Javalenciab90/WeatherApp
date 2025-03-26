package com.javalenciab90.data.room.entities

import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather

data class WeatherEntity(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
) {
    fun toModel() : Weather =
        Weather(
            description = description,
            icon = icon,
            id = id,
            main = main
        )
}