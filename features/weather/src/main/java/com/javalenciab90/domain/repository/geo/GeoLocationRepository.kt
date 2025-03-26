package com.javalenciab90.domain.repository.geo

import com.javalenciab90.models.geo.GeoLocation
import kotlinx.coroutines.flow.Flow

interface GeoLocationRepository {

    suspend fun getGeoLocation(query: String) : Flow<GeoLocation>

    //suspend fun getGeoLocation(lat: Double, lon: Double) : Flow<GeoLocation>
}