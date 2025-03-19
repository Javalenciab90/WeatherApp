package com.javalenciab90.models

data class Weather(
    val request: Request?,
    val location: Location?,
    val current: Current?
)