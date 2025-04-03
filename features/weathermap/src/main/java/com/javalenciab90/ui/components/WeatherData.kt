package com.javalenciab90.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.R
import com.javalenciab90.ui.models.WeatherMapDataUi
import com.javalenciab90.ui.models.WeatherMapDataUiPreviewProvider
import com.javalenciab90.ui.viewmodel.MapStatus
import com.javalenciab90.ui.viewmodel.WeatherMapContract

@Composable
fun WeatherDataContent(
    uiState: WeatherMapContract.MapState
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        when (uiState.status) {
            MapStatus.Loading -> {

            }
            is MapStatus.Success -> {
                WeatherData(uiData = uiState.status.data)
            }
            is MapStatus.Error -> {

            }
        }
    }
}

@Composable
fun WeatherData(
    uiData: WeatherMapDataUi
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(
            horizontal = Dimens.All_16, vertical = Dimens.All_16
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        WeatherLocation(
            cityName = uiData.name,
            lat = uiData.lat,
            lon = uiData.lon
        )
        WeatherInfo(
            uiData.icon,
            uiData.weatherDescription,
            uiData.temp
        )
    }
}

@Composable
fun WeatherLocation(
    cityName: String,
    lat: Double,
    lon: Double
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.All_16)
    ) {
        Text(text = cityName)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = null
            )
            Column {
                Text(
                    style = TextStyle(fontFamily = FontFamily.Serif),
                    text = "$lat"
                )
                Text(
                    style = TextStyle(fontFamily = FontFamily.Serif),
                    text = "$lon"
                )
            }
        }
    }

}

@Composable
fun WeatherInfo(
    @DrawableRes icon: Int,
    description: String,
    temp: Double
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(Dimens.All_48),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(text = description)
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimens.All_4)
        ) {
            Text(
                text = "${temp.toInt()}",
                style = TextStyle(fontFamily = FontFamily.Serif),
                fontSize = Dimens.Sp_30
            )
            Box(
                modifier = Modifier
                    .padding(vertical = Dimens.All_8)
                    .align(Alignment.Top)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = Dimens.All_16),
                    text = "ºC",
                    style = TextStyle(fontFamily = FontFamily.Serif),
                    fontSize = Dimens.Sp_16
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherDataPreview() {
    WeatherDataContent(
        uiState = WeatherMapContract.MapState(
            MapStatus.Success(
                WeatherMapDataUiPreviewProvider.getWeatherMapDataUi()
            )
        )
    )
}