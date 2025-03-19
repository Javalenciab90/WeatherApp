package com.javalenciab90.plataform.mapper

interface WeatherMapper<INPUT, OUTPUT> {
    fun map(input: INPUT): OUTPUT
}