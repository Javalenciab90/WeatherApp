package com.javalenciab90.ui.viewmodel

import com.javalenciab90.domain.repository.WeatherRepository
import com.javalenciab90.plataform.base.CoroutineContextProvider
import com.javalenciab90.plataform.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    coroutineContext: CoroutineContextProvider
) : MviViewModel<WeatherContract.WeatherState, WeatherContract.Effect, WeatherContract.Intent>(coroutineContext) {

    init {
        getWeather()
    }

    private fun getWeather() {
        launchInBackground {
            weatherRepository.getCurrentWeather(query = "Pereira").collect { weather ->
                weather.error?.let { error ->
                    updateNow {
                        it.copy(
                            status = Status.Error(error = error.info)
                        )
                    }
                }
                weather.current?.let { current ->
                    updateNow {
                        it.copy(
                            status = Status.Success(data = current.toString())
                        )
                    }
                }
            }
        }
    }

    override fun handleError(exception: Throwable) {
        super.handleError(exception)
        updateAsync {
            it.copy(
                status = Status.Error(exception.toString()))
        }
    }

    override fun setInitialState() = WeatherContract.WeatherState(Status.Loading)

}