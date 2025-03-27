package com.javalenciab90.common_ui.errors

interface ApiExceptionStrategy {
    fun getErrorDisplay(): ErrorDisplayUi
}