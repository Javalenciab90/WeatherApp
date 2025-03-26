package com.javalenciab90.data.mappers

import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather
import com.javalenciab90.models.openweather.WeatherCurrent
import com.javalenciab90.networkmodels.dtos.openweather.LocationDTO
import com.javalenciab90.networkmodels.dtos.openweather.MainDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherCurrentDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherDTO
import com.javalenciab90.plataform.mapper.WeatherMapper
import javax.inject.Inject

class WeatherNetworkMapper @Inject constructor(
    private val locationMapper: LocationDtoToLocationMapper,
    private val mainMapper: MainDtoToMainMapper,
    private val weatherMapper: WeatherDtoToWeatherMapper
) : WeatherMapper<WeatherCurrentDTO, WeatherCurrent> {

    override fun map(input: WeatherCurrentDTO): WeatherCurrent {
        return WeatherCurrent(
            cod = input.cod,
            location = locationMapper.map(input.location),
            id = input.id,
            main = mainMapper.map(input.main),
            name = input.name,
            weather = weatherMapper.map(input.weather)
        )
    }
}

class LocationDtoToLocationMapper @Inject constructor(
) : WeatherMapper<LocationDTO, Location> {

    override fun map(input: LocationDTO): Location {
        return Location(
            lat = input.lat,
            lon = input.lon
        )
    }
}

class MainDtoToMainMapper @Inject constructor() : WeatherMapper<MainDTO, Main> {
    override fun map(input: MainDTO): Main {
        return Main(
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

class WeatherDtoToWeatherMapper @Inject constructor() : WeatherMapper<List<WeatherDTO>, Weather> {
    override fun map(input: List<WeatherDTO>): Weather {
        return Weather(
            description = input.first().description,
            icon = input.first().icon,
            id = input.first().id,
            main = input.first().main
        )
    }
}


