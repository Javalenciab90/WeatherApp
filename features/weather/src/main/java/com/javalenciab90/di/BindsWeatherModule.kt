package com.javalenciab90.di

import com.javalenciab90.domain.repository.WeatherRepositoryImpl
import com.javalenciab90.domain.repository.WeatherRepository
import com.javalenciab90.models.Weather
import com.javalenciab90.plataform.mapper.WeatherMapper
import com.javalenciab90.ui.mappers.WeatherDataUiMapper
import com.javalenciab90.ui.models.WeatherDataUi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsWeatherModule {

    @Binds
    abstract fun bindWeatherToWeatherUiMapper(
        weatherUiMapper: WeatherDataUiMapper
    ): WeatherMapper<Weather, WeatherDataUi>

    @Binds
    abstract fun bindsWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl) : WeatherRepository
}