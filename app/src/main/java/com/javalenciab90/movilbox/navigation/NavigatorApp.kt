package com.javalenciab90.movilbox.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.javalenciab90.navigation.buildGoWeatherScreen
import com.javalenciab90.navigation.buildWeatherMapScreen
import com.javalenciab90.plataform.routes.Routes

@Composable
fun NavigatorApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Weather
    ) {
        buildGoWeatherScreen(
            navController
        )

        buildWeatherMapScreen(
            navController
        )
    }
}