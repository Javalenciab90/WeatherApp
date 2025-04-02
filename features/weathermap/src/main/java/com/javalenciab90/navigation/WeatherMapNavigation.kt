package com.javalenciab90.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.plataform.routes.Routes
import com.javalenciab90.ui.components.MapBottomSheetScaffold

fun NavGraphBuilder.buildWeatherMapScreen(
    navController: NavController
) {
    composable<Routes.WeatherMap> {
        MapBottomSheetScaffold(
            onBack = {
                navController.popBackStack()
            }
        )
    }
}
