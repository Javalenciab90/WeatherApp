package com.javalenciab90.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.components.appbar.ActionItemUi
import com.javalenciab90.components.appbar.ActionToolbarType
import com.javalenciab90.components.appbar.AppBar
import com.javalenciab90.theme.MovilBoxTheme
import com.javalenciab90.theme.R

@Composable
fun HomeScreen(
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Posts",
                actionItems = listOf(
                    ActionItemUi(
                        ActionToolbarType.OpenFilter,
                        R.drawable.ic_filter_list
                    ),
                    ActionItemUi(
                        ActionToolbarType.RefreshList,
                        R.drawable.ic_refresh
                    )
                ),
                onActionItem = { }
            )
        },
        content = {
            pageContent(it)
        }
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MovilBoxTheme {
        HomeScreen { paddingValues ->
            HomeBody(
                Unit, Unit,
                onRemoveAll = {},
                onSelectPost = {},
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}