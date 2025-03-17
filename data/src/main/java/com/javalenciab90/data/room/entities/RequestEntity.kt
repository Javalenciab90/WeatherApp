package com.javalenciab90.data.room.entities

data class RequestEntity(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)