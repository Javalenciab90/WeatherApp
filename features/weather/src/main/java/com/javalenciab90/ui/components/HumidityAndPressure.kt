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
import com.javalenciab90.theme.R

@Composable
fun HumidityAndPressure() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Humidity(58)
        Pressure(120.8)
    }
}

@Composable
fun Humidity(
    humidity: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_upward),
            contentDescription = null
        )
        Column {
            Text(
                style = TextStyle(fontFamily = FontFamily.Serif),
                text = "$humidity %"
            )
            Text(
                style = TextStyle(fontFamily = FontFamily.Serif),
                text = "Humidity"
            )
        }
    }
}

@Composable
fun Pressure(
    pressure: Double
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_upward),
            contentDescription = null
        )
        Column {
            Text(
                style = TextStyle(fontFamily = FontFamily.Serif),
                text = "$pressure %"
            )
            Text(
                style = TextStyle(fontFamily = FontFamily.Serif),
                text = "Pressue"
            )
        }
    }
}