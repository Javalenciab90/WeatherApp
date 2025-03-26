package com.javalenciab90.plataform.mapper

interface GeoLocationMapper<INPUT, OUTPUT> {
    fun map(input: INPUT): OUTPUT
}