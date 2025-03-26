package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.repository.geo.GeoLocationRepository
import com.javalenciab90.domain.repository.weather.WeatherRepository
import com.javalenciab90.models.geo.GeoLocation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGeoLocationUseCase @Inject constructor(
    private val geoLocationRepository: GeoLocationRepository
) {
    suspend operator fun invoke(query: String) : Flow<GeoLocation> {
        return geoLocationRepository.getGeoLocation(query)
    }
}