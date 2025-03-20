package com.javalenciab90.data.mappers

import com.javalenciab90.data.room.entities.CurrentEntity
import com.javalenciab90.data.room.entities.LocationEntity
import com.javalenciab90.data.room.entities.RequestEntity
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.Current
import com.javalenciab90.models.Location
import com.javalenciab90.models.Request
import com.javalenciab90.models.Weather
import com.javalenciab90.networkmodels.dtos.weather.RequestDTO
import com.javalenciab90.plataform.mapper.WeatherMapper
import javax.inject.Inject

class LocalMapper @Inject constructor(
    private val currentMapper: WeatherMapper<Current, CurrentEntity>,
    private val locationMapper: WeatherMapper<Location, LocationEntity>,
    private val requestMapper: WeatherMapper<Request, RequestEntity>
) : WeatherMapper<Weather, WeatherEntity> {

    override fun map(input: Weather): WeatherEntity {
        return WeatherEntity(
            currentEntity = input.current?.let { currentMapper.map(it) },
            locationEntity = input.location?.let { locationMapper.map(it) },
            requestEntity = input.request?.let { requestMapper.map(it) }
        )
    }
}

class CurrentToEntityMapper @Inject constructor() : WeatherMapper<Current, CurrentEntity> {

    override fun map(input: Current): CurrentEntity {
        return CurrentEntity(
            cloudcover = input.cloudcover,
            feelslike = input.feelslike,
            humidity = input.humidity,
            observation_time = input.observation_time,
            precip = input.precip,
            pressure = input.pressure,
            temperature = input.temperature,
            uv_index = input.uv_index,
            visibility = input.visibility,
            weather_code = input.weather_code,
            weather_descriptions = input.weather_descriptions,
            weather_icons = input.weather_icons,
            wind_degree = input.wind_degree,
            wind_dir = input.wind_dir,
            wind_speed = input.wind_speed
        )
    }
}

class LocationToEntityMapper @Inject constructor() : WeatherMapper<Location, LocationEntity> {
    override fun map(input: Location): LocationEntity {
        return LocationEntity(
            country = input.country,
            lat = input.lat,
            localtime = input.localtime,
            localtime_epoch = input.localtime_epoch,
            lon = input.lon,
            name = input.name,
            region = input.region,
            timezone_id = input.timezone_id,
            utc_offset = input.utc_offset
        )
    }
}

class RequestToEntityMapper @Inject constructor() : WeatherMapper<Request, RequestEntity> {

    override fun map(input: Request): RequestEntity {
        return RequestEntity(
            language = input.language,
            query = input.query,
            type = input.type,
            unit = input.unit,
        )
    }
}

