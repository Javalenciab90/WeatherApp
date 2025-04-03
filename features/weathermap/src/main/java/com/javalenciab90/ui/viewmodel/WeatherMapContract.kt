package com.javalenciab90.ui.viewmodel

import com.javalenciab90.common_ui.errors.ErrorDisplayUi
import com.javalenciab90.ui.models.MapLocation
import com.javalenciab90.ui.models.WeatherMapDataUi

sealed interface WeatherMapContract {

    data class MapState(
        val status: MapStatus
    )

    sealed interface Effect {

    }

    sealed interface Intent {

    }
}

sealed interface MapStatus {
    data object Loading : MapStatus
    data class Success(val data: WeatherMapDataUi) : MapStatus
    data class Error(val errorUi: ErrorDisplayUi) : MapStatus
}