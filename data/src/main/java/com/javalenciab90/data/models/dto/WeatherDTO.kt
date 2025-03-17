package com.javalenciab90.data.models.dto

data class WeatherDTO(
    val currentDTO: CurrentDTO,
    val locationDTO: LocationDTO,
    val requestDTO: RequestDTO
)