package com.javalenciab90.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.R
import com.javalenciab90.theme.WeatherAppTheme

@Composable
fun IconDescription(
    @DrawableRes icon: Int,
    description: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(Dimens.All_150),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(text = description)
    }
}

@Preview(showBackground = true)
@Composable
private fun IconDescriptionPreview() {
    WeatherAppTheme {
        IconDescription(
            R.drawable.ic_empty_weather,
            "Cloudy Sunny"
        )
    }
}