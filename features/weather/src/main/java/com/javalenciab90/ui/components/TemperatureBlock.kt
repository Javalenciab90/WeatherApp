package com.javalenciab90.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.R
import com.javalenciab90.theme.WeatherAppTheme

@Composable
fun TemperatureBlock(
    temp: Double,
    tempMax: Double,
    tempMin: Double,
    feelsLike: Double
) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Temperature(temp)
        TemperatureVariation(tempMax, tempMin)
        TemperatureSensation(feelsLike)
    }
}

@Composable
fun Temperature(
    temp: Double
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = temp.toString(),
            style = TextStyle(fontFamily = FontFamily.Serif),
            fontSize = Dimens.Sp_90
        )
        Box(
            modifier = Modifier.align(Alignment.Bottom)
        ) {
            Text(
                modifier = Modifier.padding(bottom = Dimens.All_16),
                text = "ºC",
                style = TextStyle(fontFamily = FontFamily.Serif),
                fontSize = Dimens.Sp_30
            )
        }
    }
}

@Composable
fun TemperatureVariation(
    tempMax: Double,
    tempMin: Double
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.All_52)
    ) {
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_upward),
                contentDescription = null
            )
            Text(
                style = TextStyle(fontFamily = FontFamily.Serif),
                text = "$tempMax ºC"
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_downward),
                contentDescription = null
            )
            Text(
                style = TextStyle(fontFamily = FontFamily.Serif),
                text = "$tempMin ºC"
            )
        }
    }
}

@Composable
fun TemperatureSensation(
    feelsLike: Double
) {
    Text(
        textAlign = TextAlign.Center,
        style = TextStyle(fontFamily = FontFamily.Serif),
        text = "Feels like \n $feelsLike ºC"
    )
}

@Preview(showBackground = true)
@Composable
fun TemperatureBlockPreview() {
    WeatherAppTheme {
        TemperatureBlock(
            temp = 28.0,
            tempMax = 35.0,
            tempMin = 25.0,
            feelsLike = 33.0
        )
    }
}
