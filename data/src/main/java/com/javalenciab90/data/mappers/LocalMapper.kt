package com.javalenciab90.data.mappers

import com.javalenciab90.data.room.entities.LocationEntity
import com.javalenciab90.data.room.entities.MainEntity
import com.javalenciab90.data.room.entities.WeatherCurrentEntity
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather
import com.javalenciab90.models.openweather.WeatherCurrent
import com.javalenciab90.plataform.mapper.WeatherMapper
import javax.inject.Inject

class WeatherLocalMapper @Inject constructor(
    private val locationMapper: LocationToEntityMapper,
    private val mainMapper: MainToEntityMapper,
    private val weatherMapper: WeatherToEntityMapper
) : WeatherMapper<WeatherCurrent, WeatherCurrentEntity> {

    override fun map(input: WeatherCurrent): WeatherCurrentEntity {
        return WeatherCurrentEntity(
            cod = input.cod,
            location = locationMapper.map(input.location),
            id = input.id,
            main = mainMapper.map(input.main),
            name = input.name,
            weather = weatherMapper.map(input.weather)
        )
    }
}

class LocationToEntityMapper @Inject constructor() : WeatherMapper<Location, LocationEntity> {

    override fun map(input: Location): LocationEntity {
        return LocationEntity(
            lat = input.lat,
            lon = input.lon
        )
    }
}

class MainToEntityMapper @Inject constructor() : WeatherMapper<Main, MainEntity> {

    override fun map(input: Main): MainEntity {
        return MainEntity(
            feelsLike = input.feelsLike,
            grndLevel = input.grndLevel,
            humidity = input.humidity,
            pressure = input.pressure,
            seaLevel = input.seaLevel,
            temp = input.temp,
            tempMax = input.tempMax,
            tempMin = input.tempMin
        )
    }
}

class WeatherToEntityMapper @Inject constructor() : WeatherMapper<Weather, WeatherEntity> {
    override fun map(input: Weather): WeatherEntity {
        return WeatherEntity(
            description = input.description,
            icon = input.icon,
            id = input.id,
            main = input.main
        )
    }
}

