package com.javalenciab90.data.datasource.local

import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.Weather

interface WeatherLocalData {
    fun insertWeatherData(weather: Weather)

    fun getWeatherData() : Weather?
}