package com.javalenciab90.plataform.routes

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes {

    @Serializable
    data object Splash: Routes

    @Serializable
    data object Home: Routes

    @Serializable
    data class Detail(val postId: String): Routes
}