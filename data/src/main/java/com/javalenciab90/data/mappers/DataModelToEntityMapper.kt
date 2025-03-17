package com.javalenciab90.data.mappers

interface DataModelToEntityMapper<DataModel, EntityModel> {
    fun mapToEntityModel(dataModel: DataModel): EntityModel
}