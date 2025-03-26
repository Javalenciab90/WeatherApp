package com.javalenciab90.data.room.entities

import com.javalenciab90.models.openweather.Main
import kotlinx.coroutines.MainScope

data class MainEntity(
    val feelsLike: Double,
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
) {
    fun toModel() : Main =
        Main(
            feelsLike = feelsLike,
            grndLevel = grndLevel,
            humidity = humidity,
            pressure = pressure,
            seaLevel = seaLevel,
            temp = temp,
            tempMax = tempMax,
            tempMin = tempMin
        )
}