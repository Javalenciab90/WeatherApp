package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.repository.weather.WeatherRepository
import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.models.openweather.WeatherCurrent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

/**
 * @flatMapLatest Operator:
 * flatMapLatest is used to transform each emitted GeoLocation object
 * from getLocationData(query) into a new Flow produced by
 * weatherRepository.getCurrentWeather().
 * Importantly, if a new GeoLocation is emitted by getLocationData
 * before the getCurrentWeather flow from the previous GeoLocation
 * has completed, flatMapLatest will cancel the previous
 * getCurrentWeather flow and start a new one with the latest
 * GeoLocation. This is often the desired behavior for search queries,
 * as you only care about the weather for the most recent location result.
 */

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val getGeoLocationUseCase: GetGeoLocationUseCase,
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    suspend operator fun invoke(query: String): Flow<WeatherCurrent> = getLocationData(query)
        .flatMapLatest { location ->
            weatherRepository.getCurrentWeather(
                query = query,
                lat = location.lat,
                lon = location.lon
            )
        }

    private suspend fun getLocationData(query: String) : Flow<GeoLocation> {
        return getGeoLocationUseCase.invoke(query = query)
    }
}