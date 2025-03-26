package com.javalenciab90.data.datasource.remote.geolocation

import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationDTO
import kotlinx.coroutines.flow.Flow

interface GeoLocationRemoteData {
    suspend fun getGeoLocationData(query: String) : Flow<GeoLocation>
}