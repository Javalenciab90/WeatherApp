package com.javalenciab90.ui.viewmodel

interface WeatherContract {

    sealed class State {
        data object Success : State()
        data object Loading : State()
        data object Failed : State()
    }

    sealed interface Effect {

    }

    sealed interface Intent {
        data object SearchOnMap : Intent
    }

}