package com.javalenciab90.ui.models

data class WeatherDataUi(
    val type: String?,
    val unit: String?,
    val country: String?,
    val lat: String?,
    val localtime: String?,
    val lon: String?,
    val name: String?,
    val region: String?,
    val humidity: Int?,
    val temperature: Int?,
    val weatherCode: Int?,
    val weatherDescriptions: List<String>?,
    val weatherIcons: List<String>?
)

object WeatherDataUiPreviewProvider {

    fun getWeatherDataUi() = WeatherDataUi(
        type = "City",
        unit = "m",
        country = "United States of America",
        lat = "40.714",
        localtime = "2019-09-07 08:14",
        lon = "-74.006",
        name = "New York",
        region = "New York",
        humidity = 90,
        temperature = 24,
        weatherCode = 113,
        weatherDescriptions = listOf("Sunny"),
        weatherIcons = listOf("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png")
    )
}