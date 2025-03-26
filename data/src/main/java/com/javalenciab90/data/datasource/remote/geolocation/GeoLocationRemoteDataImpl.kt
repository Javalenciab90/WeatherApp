package com.javalenciab90.data.datasource.remote.geolocation

import com.javalenciab90.data.mappers.GeoLocationNetworkMapper
import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.service.api.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GeoLocationRemoteDataImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val geoLocationNetworkMapper: GeoLocationNetworkMapper
) : GeoLocationRemoteData {

    override suspend fun getGeoLocationData(query: String): Flow<GeoLocation> = flow {
        try {
            val response = weatherService.getGeoLocationData(query)
            if (response.isSuccessful) {
                response.body()?.let {
                    if (it.isNotEmpty()) {
                        emit(geoLocationNetworkMapper.map(it))
                    } else {
                        throw RuntimeException("response body is null")
                    }
                } ?: throw RuntimeException("response body is null")
            } else {
                /**
                 * If is not Successful we need to handle the Exception
                 * capture code and message to create OWN EXCEPTIONS and
                 * handle it on ViewModel
                 */
                throw RuntimeException("${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}