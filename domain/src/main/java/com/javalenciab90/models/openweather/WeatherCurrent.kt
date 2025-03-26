package com.javalenciab90.models.openweather

data class WeatherCurrent(
    val cod: Int,
    val location: Location,
    val id: Int,
    val main: Main,
    val name: String,
    val weather: Weather
)