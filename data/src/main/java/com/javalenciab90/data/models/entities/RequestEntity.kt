package com.javalenciab90.data.models.entities

data class RequestEntity(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)