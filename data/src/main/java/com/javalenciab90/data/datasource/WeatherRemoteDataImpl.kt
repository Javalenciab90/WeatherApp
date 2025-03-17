package com.javalenciab90.data.datasource

import com.javalenciab90.data.mappers.DataModelToEntityMapper
import com.javalenciab90.data.mappers.EntityModelMapper
import com.javalenciab90.data.models.dto.WeatherDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRemoteDataImpl @Inject constructor(
    private val entityMapper: EntityModelMapper
) : WeatherRemoteData {

    override suspend fun getCurrentWeather(query: String): Flow<WeatherDTO> {
        TODO("Not yet implemented")
    }
}