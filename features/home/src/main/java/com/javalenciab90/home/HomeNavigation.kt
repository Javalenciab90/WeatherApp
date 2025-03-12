package com.javalenciab90.home

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.plataform.routes.Routes
import com.javalenciab90.ui.components.HomeBody
import com.javalenciab90.ui.components.HomeScreen

fun NavGraphBuilder.buildGoHomeScreen(

) {
    composable<Routes.Home> {
        HomeScreen { paddingValues ->
            HomeBody(
                Unit, Unit,
                onRemoveAll = {},
                onSelectPost = {},
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

fun NavController.navigateHome() {
    navigate(Routes.Home)
}