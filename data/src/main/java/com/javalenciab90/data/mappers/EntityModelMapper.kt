package com.javalenciab90.data.mappers

import com.javalenciab90.data.models.dto.WeatherDTO
import com.javalenciab90.data.models.entities.WeatherEntity
import javax.inject.Inject

class EntityModelMapper @Inject constructor(): DataModelToEntityMapper<WeatherDTO, WeatherEntity> {

    override fun mapToEntityModel(dataModel: WeatherDTO): WeatherEntity {
        return WeatherEntity(
            currentEntity = dataModel.currentDTO.toEntity(),
            locationEntity = dataModel.locationDTO.toEntity(),
            requestEntity = dataModel.requestDTO.toEntity()
        )
    }
}