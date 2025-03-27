package com.javalenciab90.ui.components.topbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.BeyondBoundsLayout
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.WeatherAppTheme


@Composable
fun SearchBar(
    searchText: String,
    onSearch: (String) -> Unit,
    onClearSearch: () -> Unit,
    modifier: Modifier = Modifier
) {

    val isKeyboardOpen by keyboardAsState()
    val focusManager = LocalFocusManager.current
    if (!isKeyboardOpen) focusManager.clearFocus()

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.All_2)
            .border(
                border = BorderStroke(
                    width = Dimens.All_1,
                    color = Color.DarkGray
                ),
                shape = RoundedCornerShape(Dimens.All_16)
            ),
        value = searchText,
        onValueChange =  { onSearch(it) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Search",
                color = Color.Gray
            )
        },
        keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        trailingIcon = {
            TrailingIconTextSearchInput(
                showRemoveButton = searchText.isNotBlank(),
                onCleanSearchTextPressed = onClearSearch
            )
        },
        shape = CircleShape,
        singleLine = true
    )
}

@Composable
fun TrailingIconTextSearchInput(
    showRemoveButton: Boolean,
    onCleanSearchTextPressed: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onCleanSearchTextPressed
        ) {
            if (showRemoveButton) {
                Icon(
                    modifier = Modifier.clickable {
                        onCleanSearchTextPressed()
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.Gray
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.padding(start = Dimens.All_8)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    WeatherAppTheme {
        SearchBar(
            searchText = "",
            onSearch = {},
            onClearSearch = {}
        )
    }
}