package com.javalenciab90.data.mappers

import com.javalenciab90.models.Current
import com.javalenciab90.models.Location
import com.javalenciab90.models.Request
import com.javalenciab90.models.Weather
import com.javalenciab90.models.WeatherError
import com.javalenciab90.networkmodels.dtos.weather.CurrentDTO
import com.javalenciab90.networkmodels.dtos.weather.ErrorDTO
import com.javalenciab90.networkmodels.dtos.weather.LocationDTO
import com.javalenciab90.networkmodels.dtos.weather.RequestDTO
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import com.javalenciab90.plataform.mapper.WeatherMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor(
    private val currentMapper: WeatherMapper<CurrentDTO, Current>,
    private val locationMapper: WeatherMapper<LocationDTO, Location>,
    private val requestMapper: WeatherMapper<RequestDTO, Request>,
    private val networkErrorMapper: NetworkErrorMapper
) : WeatherMapper<WeatherDTO, Weather> {

    override fun map(input: WeatherDTO): Weather {
        return Weather(
            current = input.current?.let { currentMapper.map(it) },
            location = input.location?.let { locationMapper.map(it) },
            request = input.request?.let { requestMapper.map(it) },
            error = input.error?.let { networkErrorMapper.map(it) }
        )
    }
}

class CurrentDtoToCurrentMapper @Inject constructor() : WeatherMapper<CurrentDTO, Current> {

    override fun map(input: CurrentDTO): Current {
        return Current(
            cloudcover = input.cloudcover,
            feelslike = input.feelslike,
            humidity = input.humidity,
            observation_time = input.observationTime,
            precip = input.precip,
            pressure = input.pressure,
            temperature = input.temperature,
            uv_index = input.uvIndex,
            visibility = input.visibility,
            weather_code = input.weatherCode,
            weather_descriptions = input.weatherDescriptions,
            weather_icons = input.weatherIcons,
            wind_degree = input.windDegree,
            wind_dir = input.windDir,
            wind_speed = input.windSpeed
        )
    }
}

class LocationDtoToLocationMapper @Inject constructor() : WeatherMapper<LocationDTO, Location> {
    override fun map(input: LocationDTO): Location {
        return Location(
            country = input.country,
            lat = input.lat,
            localtime = input.localtime,
            localtime_epoch = input.localtimeEpoch,
            lon = input.lon,
            name = input.name,
            region = input.region,
            timezone_id = input.timezoneId,
            utc_offset = input.utcOffset
        )
    }
}

class RequestDtoToRequestMapper @Inject constructor() : WeatherMapper<RequestDTO, Request> {

    override fun map(input: RequestDTO): Request {
        return Request(
            language = input.language,
            query = input.query,
            type = input.type,
            unit = input.unit,
        )
    }
}

class NetworkErrorMapper @Inject constructor() : WeatherMapper<ErrorDTO, WeatherError> {

    override fun map(input: ErrorDTO): WeatherError {
        return WeatherError(
            code = input.code,
            type = input.type,
            info = input.info
        )
    }
}

