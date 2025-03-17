package com.javalenciab90.data.models.dto

import com.javalenciab90.data.room.entities.RequestEntity

data class RequestDTO(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
) {
    fun toEntity() : RequestEntity {
        return RequestEntity(
            language,
            query,
            type,
            unit
        )
    }
}