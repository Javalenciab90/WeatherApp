package com.javalenciab90.domain.repository.geo

import com.javalenciab90.data.datasource.remote.geolocation.GeoLocationRemoteData
import com.javalenciab90.models.geo.GeoLocation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GeoLocationRepositoryImpl @Inject constructor(
    private val geoLocationRemoteData: GeoLocationRemoteData
) : GeoLocationRepository {

    override suspend fun getGeoLocation(query: String): Flow<GeoLocation> {
        return geoLocationRemoteData.getGeoLocationData(query)
    }
}