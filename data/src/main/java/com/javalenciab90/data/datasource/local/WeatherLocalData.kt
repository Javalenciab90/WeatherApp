package com.javalenciab90.data.datasource.local

import com.javalenciab90.models.openweather.WeatherCurrent


interface WeatherLocalData {
    fun insertWeatherData(weather: WeatherCurrent)

    fun getWeatherData(query: String) : WeatherCurrent?
}