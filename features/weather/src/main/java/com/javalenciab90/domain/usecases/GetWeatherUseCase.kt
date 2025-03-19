package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.repository.WeatherRepository
import com.javalenciab90.models.Weather
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(query: String) : Flow<Weather> {
        return weatherRepository.getCurrentWeather(query)
    }
}