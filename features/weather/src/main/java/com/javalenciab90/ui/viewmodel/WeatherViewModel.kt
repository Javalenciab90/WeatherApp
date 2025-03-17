package com.javalenciab90.ui.viewmodel

import com.javalenciab90.plataform.base.CoroutineContextProvider
import com.javalenciab90.plataform.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    coroutineContext: CoroutineContextProvider
) : MviViewModel<WeatherContract.State, WeatherContract.Effect, WeatherContract.Intent>(coroutineContext) {

    override fun setInitialState() =  WeatherContract.State.Loading

}