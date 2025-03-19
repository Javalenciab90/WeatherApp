package com.javalenciab90.data.room.entities

import com.javalenciab90.models.Location

data class LocationEntity(
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
    fun toModel() : Location {
        return Location(
            country, lat, localtime, localtime_epoch, lon, name, region, timezone_id, utc_offset
        )
    }
}