package com.javalenciab90.data.models.entities

data class WeatherEntity(
    val currentEntity: CurrentEntity,
    val locationEntity: LocationEntity,
    val requestEntity: RequestEntity
)