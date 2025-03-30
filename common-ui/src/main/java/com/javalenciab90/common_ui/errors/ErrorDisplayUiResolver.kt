package com.javalenciab90.common_ui.errors

import javax.inject.Inject

class ErrorDisplayUiResolver @Inject constructor(
    private val apiExceptionStrategy: Map<Int, @JvmSuppressWildcards ApiExceptionStrategy>
) {
    fun getErrorDisplayUi(exceptionCode: Int) : ErrorDisplayUi {
        return apiExceptionStrategy.getValue(exceptionCode).getErrorDisplay()
    }
}