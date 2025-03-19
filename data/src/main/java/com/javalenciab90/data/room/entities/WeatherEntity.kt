package com.javalenciab90.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.javalenciab90.models.Weather

@Entity(tableName = "weather_info")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val currentEntity: CurrentEntity?,
    val locationEntity: LocationEntity?,
    val requestEntity: RequestEntity?
) {
    fun toModel() : Weather {
        return Weather(
            current = currentEntity?.toModel(),
            location = locationEntity?.toModel(),
            request = requestEntity?.toModel()
        )
    }
}