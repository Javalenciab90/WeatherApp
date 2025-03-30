package com.javalenciab90.common_ui.icons

import androidx.annotation.DrawableRes
import com.javalenciab90.common_ui.icons.strategies.SimpleWeatherIconStrategy
import javax.inject.Inject

class IconWeatherUiResolver @Inject constructor(
    private val iconWeatherStrategy: IconWeatherStrategy
){
    @DrawableRes
    fun getIcon(iconId: String) : Int {
        return iconWeatherStrategy.getIconWeather(iconId)
    }
}