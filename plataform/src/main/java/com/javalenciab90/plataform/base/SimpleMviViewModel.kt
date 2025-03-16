package com.javalenciab90.plataform.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


/**
 * To use on ViewModel juts need to
 * Inject the coroutineDispatcher
 * viewModelScope.launch(coroutineDispatcher) { updateState() }
 */

abstract class SimpleMviViewModel<UiState, UiEvent, Effect> : ViewModel() {
    private val mutableUiState by lazy { MutableStateFlow(initialState()) }
    val uiState: StateFlow<UiState> by lazy { mutableUiState.asStateFlow() }

    private val channelEffects: Channel<Effect> = Channel()
    val effects: Flow<Effect> = channelEffects.receiveAsFlow()

    protected val currentUiState: UiState get() = uiState.value

    fun updateState(reducer: UiState.() -> UiState) {
        val newState = uiState.value.reducer()
        mutableUiState.value = newState
    }

    fun sendEffect(effect: Effect) {
        viewModelScope.launch {
            channelEffects.send(effect)
        }
    }

    abstract fun initialState(): UiState

    abstract fun onUiEvent(uiEvent: UiEvent)
}

