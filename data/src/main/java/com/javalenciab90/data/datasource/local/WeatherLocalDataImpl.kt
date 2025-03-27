package com.javalenciab90.data.datasource.local

import com.javalenciab90.data.mappers.DataLocalMapper
import com.javalenciab90.data.room.database.WeatherDao
import com.javalenciab90.models.openweather.WeatherCurrent
import javax.inject.Inject

class WeatherLocalDataImpl @Inject constructor(
    private val weatherDao: WeatherDao,
    private val localMapper: DataLocalMapper
) : WeatherLocalData {

    override fun insertWeatherData(weather: WeatherCurrent) {
        val weatherEntity = localMapper.map(weather)
        weatherDao.insertWeatherInfo(weatherEntity)
    }

    override fun getWeatherData(query: String): WeatherCurrent? {
        return weatherDao.getWeatherInfo(query)?.toModel()
    }
}