package com.javalenciab90.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.components.error.ErrorScreen
import com.javalenciab90.components.loading.LoadingScreen
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.WeatherAppTheme
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
            Text(uiState.status.data)
        }
        is Status.Error -> {
            ErrorScreen(modifier = modifier)
        }
    }
}

@Composable
fun WeatherContent(
    onMapSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Todo: Set View Of Weather Data
        StickyFooter(
            onMapSearch = onMapSearch,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
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
private fun StickyFooterPreview() {
    WeatherAppTheme {
        StickyFooter(
            onMapSearch = { }
        )
    }
}
