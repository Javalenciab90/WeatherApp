package com.javalenciab90.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.javalenciab90.theme.Dimens
import com.javalenciab90.ui.viewmodel.WeatherMapViewModel

private val DefaultCollapsedHeight = 56.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapBottomSheetScaffold(
    viewModel: WeatherMapViewModel = hiltViewModel(),
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Expanded
        )
    )

    BottomSheetScaffold(
        modifier = modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetPeekHeight = DefaultCollapsedHeight,
        sheetMaxWidth = BottomSheetDefaults.SheetMaxWidth,
        sheetShape = RoundedCornerShape(
            topStart = Dimens.All_16,
            topEnd = Dimens.All_16
        ),
        topBar = {
            TopMapBar { onBack() }
        },
        sheetContent = {
            //WeatherData()
        },
        sheetDragHandle = {

        },
    ) {
    }
}

