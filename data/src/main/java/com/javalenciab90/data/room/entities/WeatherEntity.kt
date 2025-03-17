package com.javalenciab90.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_info")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val currentEntity: CurrentEntity,
    val locationEntity: LocationEntity,
    val requestEntity: RequestEntity
)