package com.javalenciab90.utils

class ApiException(
    val errorCode: Int,
    override val message: String?
) : RuntimeException(message)