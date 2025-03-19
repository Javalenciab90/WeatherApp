package com.javalenciab90.ui.viewmodel

data class State(
    val data: String? = null,
    val error: String? = null
)

sealed interface Effect {

}

sealed interface Intent {
    data object SearchOnMap : Intent
}