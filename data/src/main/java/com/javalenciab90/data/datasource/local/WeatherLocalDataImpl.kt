package com.javalenciab90.data.datasource.local

import com.javalenciab90.data.mappers.LocalMapper
import com.javalenciab90.data.room.database.WeatherDao
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.Weather
import javax.inject.Inject

class WeatherLocalDataImpl @Inject constructor(
    private val weatherDao: WeatherDao,
    private val localMapper: LocalMapper
) : WeatherLocalData {

    override fun insertWeatherData(weather: Weather) {
        val weatherEntity = localMapper.map(weather)
        weatherDao.insertWeatherInfo(weatherEntity)
    }

    override fun getWeatherData(): Weather? {
        return weatherDao.getWeatherInfo()?.toModel()
    }
}