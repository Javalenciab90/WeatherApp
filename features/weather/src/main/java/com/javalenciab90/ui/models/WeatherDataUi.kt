package com.javalenciab90.ui.models

import androidx.annotation.DrawableRes
import com.javalenciab90.common_ui.R
import com.javalenciab90.models.openweather.WeatherCurrent

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
    val icon: Int,
    val weatherDescription: String
) {
    constructor(model: WeatherCurrent, @DrawableRes icon: Int) : this (
        name = model.name,
        lat = model.location.lat,
        lon = model.location.lon,
        pressure = model.main.pressure,
        humidity = model.main.humidity,
        temp = model.main.temp,
        feelsLike = model.main.feelsLike,
        tempMax = model.main.tempMax,
        tempMin = model.main.tempMin,
        icon = icon,
        weatherDescription = model.weather.description
    )
}

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
        icon = R.drawable.ic_weather_moon_stars,
        weatherDescription = "Moon Night"
    )
}