package com.javalenciab90.data.models.dto

import com.javalenciab90.data.models.entities.LocationEntity

data class LocationDTO(
    val country: String,
    val lat: String,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: String,
    val name: String,
    val region: String,
    val timezone_id: String,
    val utc_offset: String
) {
    fun toEntity() : LocationEntity {
        return LocationEntity(
            country,
            lat,
            localtime,
            localtime_epoch,
            lon,
            name,
            region,
            timezone_id,
            utc_offset
        )
    }
}