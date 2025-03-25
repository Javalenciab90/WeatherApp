package com.javalenciab90.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.javalenciab90.components.error.ErrorScreen
import com.javalenciab90.components.loading.LoadingScreen
import com.javalenciab90.theme.Dimens
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
        is Status.Error -> {
            ErrorScreen(modifier = modifier)
        }
    }
}

@Composable
fun WeatherContent(
    uiData: WeatherDataUi,
    onMapSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            uiData.weatherIcons?.first()?.let {
                AsyncImage(
                    model = it,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(Dimens.All_48))
                        .size(Dimens.All_100)
                )
            }
            StickyFooter(
                onMapSearch = onMapSearch
            )
        }
    }
}

@Composable
fun StickyFooter(
    onMapSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.All_16)
            .clickable { onMapSearch() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Search on Map View",
            textAlign = TextAlign.Center
        )
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
            contentDescription = null
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
