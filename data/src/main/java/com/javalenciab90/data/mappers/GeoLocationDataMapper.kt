package com.javalenciab90.data.mappers

import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationListDTO
import com.javalenciab90.mapper.DataMapper
import com.javalenciab90.utils.ApiException
import javax.inject.Inject

class GeoLocationDataMapper @Inject constructor() : DataMapper<GeoLocationListDTO, GeoLocation> {

    override fun map(input: GeoLocationListDTO): GeoLocation {
        return if (input.isNotEmpty()) {
            GeoLocation(
                country = input.first().country,
                lat = input.first().lat,
                lon = input.first().lon,
                name = input.first().name,
                state = input.first().state
            )
        } else {
            throw ApiException(
                errorCode = -1,
                message = "GeoLocationDataMapper: GeoLocation List is empty"
            )
        }
    }
}

