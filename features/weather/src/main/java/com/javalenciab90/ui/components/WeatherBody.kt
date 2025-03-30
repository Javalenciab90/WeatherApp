package com.javalenciab90.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.components.empty.EmptyScreen
import com.javalenciab90.components.error.ErrorScreen
import com.javalenciab90.components.loading.LoadingScreen
import com.javalenciab90.theme.R
import com.javalenciab90.theme.WeatherAppTheme
import com.javalenciab90.ui.models.WeatherDataUi
import com.javalenciab90.ui.models.WeatherDataUiPreviewProvider
import com.javalenciab90.ui.viewmodel.Status
import com.javalenciab90.ui.viewmodel.WeatherContract

@Composable
fun WeatherBody(
    uiState: WeatherContract.WeatherState,
    onHandleIntent: (WeatherContract.Intent) -> Unit,
    modifier: Modifier = Modifier
) {
    when (uiState.status) {
        is Status.Loading -> {
            LoadingScreen()
        }
        is Status.Success -> {
            WeatherContent(
                modifier = modifier,
                uiData = uiState.status.data,
                onMapSearch = {
                    onHandleIntent(WeatherContract.Intent.SearchOnMap)
                }
            )
        }
        is Status.Empty -> {
            EmptyScreen()
        }
        is Status.Error -> {
            ErrorScreen(
                title = uiState.status.errorUi.titleResId,
                message = uiState.status.errorUi.messageResId,
                icon = uiState.status.errorUi.iconResId,
                modifier = modifier
            )
        }
    }
}

@Composable
fun WeatherContent(
    uiData: WeatherDataUi,
    onMapSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeadlineLocation(
            name = uiData.name,
            lat = uiData.lat,
            lon = uiData.lon
        )
        TemperatureBlock(
            temp = uiData.temp,
            tempMax = uiData.tempMax,
            tempMin = uiData.tempMin,
            feelsLike = uiData.feelsLike
        )
        IconDescription(
            uiData.icon,
            uiData.weatherDescription
        )
        HumidityAndPressure()
        StickyFooter(
            onMapSearch = onMapSearch
        )
    }
}



@Preview(showBackground = true)
@Composable
private fun WeatherContentPreview() {
    WeatherAppTheme {
        WeatherContent(
            uiData = WeatherDataUiPreviewProvider.getWeatherDataUi(),
            onMapSearch = {}
        )
    }
}
