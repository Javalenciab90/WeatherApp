package com.javalenciab90.mapper

interface DataMapper<INPUT, OUTPUT> {
    fun map(input: INPUT): OUTPUT
}