package com.javalenciab90.components.error

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.WeatherAppTheme

@Composable
fun ErrorScreen(
    @StringRes title: Int,
    @StringRes message: Int,
    @DrawableRes icon: Int? = null,
    modifier: Modifier = Modifier,
    onRetryClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.All_16)
        ) {
            Box(
                modifier = Modifier
                    .size(Dimens.All_48)
                    .background(Color.Red, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(Dimens.All_24),
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(Dimens.All_24),
                    )
                }

            }

            Text(text = stringResource(title))

            Text(text = stringResource(message))

            onRetryClick?.let {
                IconButton(
                    onClick = onRetryClick
                ) {
                    Text("Retry")
                }
            }
        }
    }

}

@SuppressLint("ResourceType")
@Preview(showBackground = true)
@Composable
private fun ErrorScreenPreview() {
    WeatherAppTheme {
        ErrorScreen(
            title = 0,
            message = 1,
            icon = null
        )
    }
}
