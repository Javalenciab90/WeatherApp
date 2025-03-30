package com.javalenciab90.data.room.entities

import com.javalenciab90.models.openweather.Weather

data class WeatherEntity(
    val description: String,
    val iconId: String,
    val id: Int,
    val main: String
) {
    fun toModel() : Weather =
        Weather(
            description = description,
            iconId = iconId,
            id = id,
            main = main
        )
}