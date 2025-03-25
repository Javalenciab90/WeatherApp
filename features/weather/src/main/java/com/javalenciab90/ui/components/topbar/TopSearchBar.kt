package com.javalenciab90.ui.components.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.Dimens
import com.javalenciab90.theme.WeatherAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSearchBar(
    searchText: String,
    onSearch: (String) -> Unit,
    onClearSearch: () -> Unit,
    onSettingsClick: () -> Unit
) {
    TopAppBar(
        title = { Text("") }, // Empty title to accommodate custom layout
        actions = {
            Row(
                modifier = Modifier
                    .padding(end = Dimens.All_8),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onSettingsClick) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = null
                    )
                }
                SearchBar(
                    searchText = searchText,
                    onSearch =  { onSearch(it) },
                    onClearSearch = onClearSearch
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    WeatherAppTheme {
        TopSearchBar(
            searchText = "",
            onSearch = {},
            onClearSearch = {},
            onSettingsClick = { }
        )
    }
}