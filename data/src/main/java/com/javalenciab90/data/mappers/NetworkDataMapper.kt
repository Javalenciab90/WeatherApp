package com.javalenciab90.data.mappers

import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather
import com.javalenciab90.models.openweather.WeatherCurrent
import com.javalenciab90.networkmodels.dtos.openweather.LocationDTO
import com.javalenciab90.networkmodels.dtos.openweather.MainDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherCurrentDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherDTO
import com.javalenciab90.mapper.DataMapper
import javax.inject.Inject

class NetworkDataMapper @Inject constructor(
    private val locationMapper: LocationDtoToLocationMapper,
    private val mainMapper: MainDtoToMainMapper,
    private val weatherMapper: WeatherDtoToDataMapper
) : DataMapper<WeatherCurrentDTO, WeatherCurrent> {

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
) : DataMapper<LocationDTO, Location> {

    override fun map(input: LocationDTO): Location {
        return Location(
            lat = input.lat,
            lon = input.lon
        )
    }
}

class MainDtoToMainMapper @Inject constructor() : DataMapper<MainDTO, Main> {
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

class WeatherDtoToDataMapper @Inject constructor() : DataMapper<List<WeatherDTO>, Weather> {
    override fun map(input: List<WeatherDTO>): Weather {
        return Weather(
            description = input.first().description,
            iconId = input.first().iconId,
            id = input.first().id,
            main = input.first().main
        )
    }
}


