package com.javalenciab90.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeBody(
    uiState: Unit,
    onHandleIntent: Unit,
    onSelectPost: () -> Unit,
    onRemoveAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    HomeContent(
        onRemoveAll = onRemoveAll,
        onSelectPost = onSelectPost,
        modifier
    )
}

@Composable
fun HomeContent(
    onRemoveAll: () -> Unit,
    onSelectPost: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f)
            ) {
                items(35) { item ->
                    Text(
                        modifier = Modifier.clickable { onSelectPost() },
                        text = "Item: $item"
                    )
                }
            }
        }
        StickyFooter(
            onRemoveAll = { },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun StickyFooter(
    onRemoveAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable {
        onRemoveAll()
    }) {
        Text(
            text = "Footer: Remove All",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
        )
    }
}