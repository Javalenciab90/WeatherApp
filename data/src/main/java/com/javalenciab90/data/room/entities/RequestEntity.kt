package com.javalenciab90.data.room.entities

import com.javalenciab90.models.Request

data class RequestEntity(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
) {
    fun toModel() : Request {
        return Request(
            language, query, type, unit
        )
    }
}