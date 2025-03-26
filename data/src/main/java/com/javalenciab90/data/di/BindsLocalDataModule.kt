package com.javalenciab90.data.di

import com.javalenciab90.data.mappers.LocationToEntityMapper
import com.javalenciab90.data.mappers.MainToEntityMapper
import com.javalenciab90.data.mappers.WeatherLocalMapper
import com.javalenciab90.data.mappers.WeatherToEntityMapper
import com.javalenciab90.data.room.entities.LocationEntity
import com.javalenciab90.data.room.entities.MainEntity
import com.javalenciab90.data.room.entities.WeatherCurrentEntity
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather
import com.javalenciab90.models.openweather.WeatherCurrent
import com.javalenciab90.plataform.mapper.WeatherMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsLocalDataModule {

    @Binds
    abstract fun bindWeatherCurrentToEntityMapper(
        mapper: WeatherLocalMapper
    ): WeatherMapper<WeatherCurrent, WeatherCurrentEntity>

    @Binds
    abstract fun bindLocationToEntityMapper(
        mapper: LocationToEntityMapper
    ): WeatherMapper<Location, LocationEntity>

    @Binds
    abstract fun bindMainToEntityMapper(
        mapper: MainToEntityMapper
    ): WeatherMapper<Main, MainEntity>

    @Binds
    abstract fun bindWeatherToEntityMapper(
        mapper: WeatherToEntityMapper
    ): WeatherMapper<Weather, WeatherEntity>

}