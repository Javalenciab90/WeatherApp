package com.javalenciab90.ui.viewmodel

import com.javalenciab90.common_ui.errors.ErrorDisplayUi
import com.javalenciab90.ui.models.WeatherDataUi

class WeatherContract {

    data class WeatherState(
        val searchText: String = "",
        val status: Status
    )

    sealed interface Effect {

    }

    sealed interface Intent {
        data class Search(val text: String) : Intent
        data object ClearSearch: Intent
        data object SearchOnMap : Intent
        data object OpenSettings : Intent
    }
}

sealed interface Status {
    data object Loading : Status
    data class Success(val data: WeatherDataUi) : Status
    data class Error(val errorUi: ErrorDisplayUi) : Status
    data object Empty : Status
}
