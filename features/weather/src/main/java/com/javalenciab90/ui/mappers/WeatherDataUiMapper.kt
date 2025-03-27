package com.javalenciab90.ui.mappers

//
//class WeatherDataUiMapper @Inject constructor() : WeatherMapper<Weather, WeatherDataUi> {
//
//    override fun map(input: Weather): WeatherDataUi {
//        return WeatherDataUi(
//            type = input.request?.type,
//            unit = input.request?.unit,
//            country = input.location?.country,
//            lat = input.location?.lat,
//            localtime = input.location?.localtime,
//            lon = input.location?.lon,
//            name = input.location?.name,
//            region = input.location?.region,
//            humidity = input.current?.humidity,
//            temperature = input.current?.temperature,
//            weatherCode = input.current?.weather_code,
//            weatherDescriptions = input.current?.weather_descriptions,
//            weatherIcons = input.current?.weather_icons
//        )
//    }
//}