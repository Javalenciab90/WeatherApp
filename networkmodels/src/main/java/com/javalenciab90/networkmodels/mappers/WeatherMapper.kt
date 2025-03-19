package com.javalenciab90.networkmodels.mappers

interface NetworkToModelMapper<INPUT, OUTPUT> {
    fun mapToModel(input: INPUT): OUTPUT
}