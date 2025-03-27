package com.javalenciab90.common_ui.errors

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ErrorDisplayUi(
    @StringRes val titleResId: Int,
    @StringRes val messageResId: Int,
    @DrawableRes val iconResId: Int? = null
)
