package com.javalenciab90.data.datasource.remote.geolocation

import com.javalenciab90.data.datasource.remote.FetchRemoteData
import com.javalenciab90.data.mappers.GeoLocationDataMapper
import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationListDTO
import com.javalenciab90.service.api.WeatherService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GeoLocationRemoteDataImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val geoLocationNetworkMapper: GeoLocationDataMapper
) : GeoLocationRemoteData, FetchRemoteData<GeoLocationListDTO, GeoLocation>() {

    override suspend fun getGeoLocationData(
        query: String
    ): Flow<GeoLocation> = getData(
            apiCall = { weatherService.getGeoLocationData(query) },
            mapper = geoLocationNetworkMapper
    )
}