package com.javalenciab90.data.models.dto

import com.javalenciab90.data.room.entities.CurrentEntity

data class CurrentDTO(
    val cloudcover: Int,
    val feelslike: Int,
    val humidity: Int,
    val observation_time: String,
    val precip: Int,
    val pressure: Int,
    val temperature: Int,
    val uv_index: Int,
    val visibility: Int,
    val weather_code: Int,
    val weather_descriptions: List<String>,
    val weather_icons: List<String>,
    val wind_degree: Int,
    val wind_dir: String,
    val wind_speed: Int
) {
    fun toEntity() : CurrentEntity {
        return CurrentEntity(
            cloudcover,
            feelslike,
            humidity,
            observation_time,
            precip, pressure,
            temperature,
            uv_index,
            visibility,
            weather_code,
            weather_descriptions,
            weather_icons,
            wind_degree,
            wind_dir,
            wind_speed
        )
    }
}