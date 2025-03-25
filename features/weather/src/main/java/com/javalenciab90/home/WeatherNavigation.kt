package com.javalenciab90.home

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.plataform.effect.ObserveEffects
import com.javalenciab90.plataform.routes.Routes
import com.javalenciab90.ui.components.WeatherBody
import com.javalenciab90.ui.components.WeatherScreen
import com.javalenciab90.ui.viewmodel.WeatherContract
import com.javalenciab90.ui.viewmodel.WeatherViewModel

fun NavGraphBuilder.buildGoWeatherScreen(

) {
    composable<Routes.Home> {

        val viewModel: WeatherViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {

        }

        ObserveEffects(flow = viewModel.sideEffect) { effect ->

        }

        WeatherScreen(
            text = uiState.searchText,
            onHandleIntent = viewModel::handleIntent
        ) { paddingValues ->
            WeatherBody(
                uiState = uiState,
                onHandleIntent = viewModel::handleIntent,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

fun NavController.navigateHome() {
    navigate(Routes.Home)
}