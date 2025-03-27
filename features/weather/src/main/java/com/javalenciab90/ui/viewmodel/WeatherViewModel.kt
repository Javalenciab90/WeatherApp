package com.javalenciab90.ui.viewmodel

import com.javalenciab90.common_ui.errors.ErrorDisplayUiResolver
import com.javalenciab90.domain.usecases.GetWeatherUseCase
import com.javalenciab90.plataform.base.CoroutineContextProvider
import com.javalenciab90.plataform.base.MviViewModel
import com.javalenciab90.theme.Dimens
import com.javalenciab90.ui.models.WeatherDataUiPreviewProvider
import com.javalenciab90.utils.ApiException
import com.javalenciab90.utils.CodeExceptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val errorDisplayUiResolver: ErrorDisplayUiResolver,
    coroutineContext: CoroutineContextProvider
) : MviViewModel<WeatherContract.WeatherState, WeatherContract.Effect, WeatherContract.Intent>(coroutineContext) {

    init {
        launchInMain {
            uiState.debounce(Dimens.Milliseconds500)
                .map { it.searchText }
                .distinctUntilChanged()
                .flowOn(Dispatchers.Default)
                .collect { query ->
                    getWeather(query)
                }
        }
    }

    private fun getWeather(query: String) {
        if (query.isBlank()) {
            updateNow {
                it.copy(
                    status = Status.Empty
                )
            }
        } else {
            launchInBackground {
                getWeatherUseCase(query = query).collect {
                    updateNow {
                        it.copy(
                            searchText = query,
                            status = Status.Success(data = WeatherDataUiPreviewProvider.getWeatherDataUi())
                        )
                    }
                }
            }
        }
    }

    override fun handleIntent(intent: WeatherContract.Intent) {
        when(intent) {
            is WeatherContract.Intent.Search -> {
                updateSearchText(intent.text)
            }
            WeatherContract.Intent.ClearSearch -> {
                clearSearchText()
            }
            WeatherContract.Intent.SearchOnMap -> {
                // TODO: Open Map Screen.
            }
            WeatherContract.Intent.OpenSettings -> {
                // TODO: Open Settings.
            }
        }
    }

    private fun clearSearchText() {
        updateNow {
            it.copy(
                searchText = ""
            )
        }
    }

    private fun updateSearchText(text: String) {
        updateNow {
            it.copy(
                searchText = text
            )
        }
    }

    override fun handleError(exception: Throwable) {
        super.handleError(exception)
        val errorDisplayUi =
            if (exception is ApiException) {
                errorDisplayUiResolver.getErrorDisplayUi(exception.errorCode)
            } else {
                errorDisplayUiResolver.getErrorDisplayUi(CodeExceptions.GENERIC_ERROR)
            }
        updateAsync {
            it.copy(
                status = Status.Error(errorUi = errorDisplayUi)
            )
        }
    }

    override fun setInitialState() = WeatherContract.WeatherState(status = Status.Loading)

}