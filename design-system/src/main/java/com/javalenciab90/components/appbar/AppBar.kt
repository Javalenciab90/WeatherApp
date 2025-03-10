package com.javalenciab90.components.appbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.theme.MovilBoxTheme
import com.javalenciab90.theme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDefaultBar(
    title: String,
    actionItems: List<ActionItemUi> = emptyList(),
    modifier: Modifier = Modifier,
    onActionItem: ((ActionToolbarType) -> Unit) ? = null,
    navIcon: (@Composable () -> Unit) = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(text = title)
        },
        actions = {
            actionItems.forEach { itemUi ->
                IconButton(
                    onClick = {
                        onActionItem?.invoke(itemUi.actionType)
                    }
                ) {
                    Icon(
                        painter = painterResource(itemUi.icon),
                        contentDescription = null
                    )
                }
            }
        },
        navigationIcon = {
            navIcon()
        },
    )
}

@Preview(
    showBackground = true,
    name = "Default title"
)
@Composable
private fun AppDefaultBarPreview() {
    MovilBoxTheme {
        AppDefaultBar(
            title = "Test AppBar"
        )
    }
}

@Preview(
    showBackground = true,
    name = "Toolbar with NavIcon"
)
@Composable
private fun AppDefaultBarWithNavIcon() {
    MovilBoxTheme {
        AppDefaultBar(
            title = "Test AppBar"
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painterResource(R.drawable.ic_arrow_back),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Toolbar with ActionItems"
)
@Composable
private fun AppDefaultBarWithActionItems() {
    MovilBoxTheme {
        AppDefaultBar(
            title = "Test AppBar",
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
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painterResource(R.drawable.ic_arrow_back),
                    contentDescription = null
                )
            }
        }
    }
}
