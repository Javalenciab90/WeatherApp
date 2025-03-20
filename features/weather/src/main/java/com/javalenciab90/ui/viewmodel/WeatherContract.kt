package com.javalenciab90.ui.viewmodel

class WeatherContract {
    data class WeatherState(
        val status: Status
    )

    sealed interface Effect {

    }

    sealed interface Intent {
        data object SearchOnMap : Intent
    }
}

sealed interface Status {
    data object Loading : Status
    data class Success(val data: String) : Status
    data class Error(val error: String) : Status
}
