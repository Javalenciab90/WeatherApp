package com.javalenciab90.data.mappers

import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationListDTO
import com.javalenciab90.plataform.mapper.GeoLocationMapper
import javax.inject.Inject

class GeoLocationNetworkMapper @Inject constructor() : GeoLocationMapper<GeoLocationListDTO, GeoLocation> {

    override fun map(input: GeoLocationListDTO): GeoLocation {
        return GeoLocation(
            country = input.first().country,
            lat = input.first().lat,
            lon = input.first().lon,
            name = input.first().name,
            state = input.first().state
        )
    }
}

