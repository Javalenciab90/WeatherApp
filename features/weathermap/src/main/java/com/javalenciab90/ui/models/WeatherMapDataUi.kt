package com.javalenciab90.ui.models

import androidx.annotation.DrawableRes
import com.javalenciab90.common_ui.R
import com.javalenciab90.models.openweather.WeatherCurrent

data class WeatherMapDataUi(
    val name: String,
    val lat: Double,
    val lon: Double,
    val temp: Double,
    val icon: Int,
    val weatherDescription: String
) {
    constructor(model: WeatherCurrent, @DrawableRes icon: Int) : this (
        name = model.name,
        lat = model.location.lat,
        lon = model.location.lon,
        temp = model.main.temp,
        icon = icon,
        weatherDescription = model.weather.description
    )
}

object WeatherMapDataUiPreviewProvider {
    fun getWeatherMapDataUi() = WeatherMapDataUi(
        name = "New York",
        lat = 40.714,
        lon = -74.006,
        temp = 24.5,
        icon = R.drawable.ic_weather_moon_stars,
        weatherDescription = "Moon Night"
    )
}
