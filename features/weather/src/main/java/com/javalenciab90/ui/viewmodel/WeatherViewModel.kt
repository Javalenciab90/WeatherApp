package com.javalenciab90.ui.viewmodel

import android.util.Log
import com.javalenciab90.domain.repository.WeatherRepository
import com.javalenciab90.plataform.base.CoroutineContextProvider
import com.javalenciab90.plataform.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    coroutineContext: CoroutineContextProvider
) : MviViewModel<State, Effect, Intent>(coroutineContext) {

    init {
        getWeather()
    }

    private fun getWeather() {
        launchInBackground {
            weatherRepository.getCurrentWeather(query = "Pereira").collect { weather ->
                updateNow {
                    it.copy(data = weather.toString())
                }
            }
        }
    }

    override fun handleError(exception: Throwable) {
        super.handleError(exception)
        updateAsync {
            it.copy(data = exception.toString())
        }
    }

    override fun setInitialState() = State()

}