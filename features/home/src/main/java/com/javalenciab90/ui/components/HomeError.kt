package com.javalenciab90.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.javalenciab90.theme.Dimens

@Composable
fun HomeError(
    modifier: Modifier = Modifier,
    onRetryClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .background(Color.Red, CircleShape)
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            modifier = Modifier.size(Dimens.All_24),
        )
    }

    Text(text = "Error")

    Text(
        text = "Message",
    )

    onRetryClick?.let {
        IconButton(
            onClick = onRetryClick
        ) {
            Text("Retry")
        }
    }

}