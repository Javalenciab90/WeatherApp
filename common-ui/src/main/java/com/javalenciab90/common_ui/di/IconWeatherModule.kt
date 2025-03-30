package com.javalenciab90.common_ui.di

import com.javalenciab90.common_ui.icons.IconWeatherStrategy
import com.javalenciab90.common_ui.icons.IconWeatherUiResolver
import com.javalenciab90.common_ui.icons.strategies.SimpleWeatherIconStrategy
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class IconWeatherModule {

    @Binds
    abstract fun bindWeatherIconStrategy(
        simpleWeatherIconStrategy: SimpleWeatherIconStrategy
    ): IconWeatherStrategy

    companion object {
        @Provides
        fun provideIconResolver(strategy: IconWeatherStrategy): IconWeatherUiResolver {
            return IconWeatherUiResolver(strategy)
        }
    }
}