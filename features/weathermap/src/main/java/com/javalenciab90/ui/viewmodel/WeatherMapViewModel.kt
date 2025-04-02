package com.javalenciab90.ui.viewmodel

import com.javalenciab90.plataform.base.CoroutineContextProvider
import com.javalenciab90.plataform.base.MviViewModel
import com.javalenciab90.ui.models.WeatherMapDataUiPreviewProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherMapViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider
) : MviViewModel<WeatherMapContract.MapState, WeatherMapContract.Effect, WeatherMapContract.Intent>(contextProvider) {

    init {
        updateNow {
            it.copy(
                status =  MapStatus.Success(WeatherMapDataUiPreviewProvider.getWeatherMapDataUi())
            )
        }
    }

    override fun setInitialState() = WeatherMapContract.MapState(status = MapStatus.Loading)
}