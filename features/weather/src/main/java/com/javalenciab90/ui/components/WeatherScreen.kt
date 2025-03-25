package com.javalenciab90.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.WeatherAppTheme
import com.javalenciab90.ui.components.topbar.TopSearchBar
import com.javalenciab90.ui.models.WeatherDataUiPreviewProvider
import com.javalenciab90.ui.viewmodel.Status
import com.javalenciab90.ui.viewmodel.WeatherContract

@Composable
fun WeatherScreen(
    text: String,
    onHandleIntent: (WeatherContract.Intent) -> Unit,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopSearchBar(
                searchText = text,
                onSearch = { searchText ->
                    onHandleIntent(WeatherContract.Intent.Search(searchText))
                },
                onClearSearch = {
                    onHandleIntent(WeatherContract.Intent.ClearSearch)
                },
                onSettingsClick = {
                    onHandleIntent(WeatherContract.Intent.OpenSettings)
                }
            )
        },
        content = {
            pageContent(it)
        }
    )
}

@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherAppTheme {
        WeatherScreen(
            text = "",
            onHandleIntent = { }
        ) { paddingValues ->
            WeatherBody(
                uiState = WeatherContract.WeatherState(
                    status = Status.Success(
                        data = WeatherDataUiPreviewProvider.getWeatherDataUi()
                    )
                ),
                onHandleIntent = {},
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}