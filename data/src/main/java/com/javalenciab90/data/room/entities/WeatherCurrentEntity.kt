package com.javalenciab90.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.javalenciab90.models.openweather.WeatherCurrent

@Entity(tableName = "weather_table")
data class WeatherCurrentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val cod: Int,
    val location: LocationEntity,
    val main: MainEntity,
    val name: String,
    val weather: WeatherEntity
) {
    fun toModel() : WeatherCurrent =
        WeatherCurrent(
            cod = cod,
            location = location.toModel(),
            id = id,
            main = main.toModel(),
            name = name,
            weather = weather.toModel()
        )
}