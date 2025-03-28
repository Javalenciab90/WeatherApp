package com.javalenciab90.ui.models

data class WeatherDataUi(
    val name: String,
    val lat: Double,
    val lon: Double,
    val pressure: Int,
    val humidity: Int,
    val temp: Double,
    val feelsLike: Double,
    val tempMax: Double,
    val tempMin: Double,
    val weatherDescription: String
)

object WeatherDataUiPreviewProvider {
    fun getWeatherDataUi() = WeatherDataUi(
        name = "New York",
        lat = 40.714,
        lon = -74.006,
        pressure = 1,
        humidity = 90,
        temp = 24.5,
        feelsLike = 26.0,
        tempMax = 27.0,
        tempMin = 20.0,
        weatherDescription = "Sunny"
    )
}