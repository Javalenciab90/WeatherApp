package com.javalenciab90.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.javalenciab90.theme.WeatherAppTheme

@Composable
fun HeadlineLocation(
    name: String,
    lon: Double,
    lat: Double
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceAround
    ) {
        Text(
            text = name,
            style = TextStyle(fontFamily = FontFamily.Serif),
            fontSize = Dimens.Sp_48
        )
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

@Preview(showBackground = true)
@Composable
private fun HeadlineLocationPreview() {
    WeatherAppTheme {
        HeadlineLocation(
            "Manizales",
            4.23322,
            -75.909900
        )
    }
}