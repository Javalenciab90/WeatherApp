package com.javalenciab90.data.di

import com.javalenciab90.data.mappers.CurrentDtoToCurrentMapper
import com.javalenciab90.data.mappers.CurrentToEntityMapper
import com.javalenciab90.data.mappers.LocalMapper
import com.javalenciab90.data.mappers.LocationDtoToLocationMapper
import com.javalenciab90.data.mappers.LocationToEntityMapper
import com.javalenciab90.data.mappers.NetworkErrorMapper
import com.javalenciab90.data.mappers.NetworkMapper
import com.javalenciab90.data.mappers.RequestDtoToRequestMapper
import com.javalenciab90.data.mappers.RequestToEntityMapper
import com.javalenciab90.data.room.entities.CurrentEntity
import com.javalenciab90.data.room.entities.LocationEntity
import com.javalenciab90.data.room.entities.RequestEntity
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.Current
import com.javalenciab90.models.Location
import com.javalenciab90.models.Request
import com.javalenciab90.models.Weather
import com.javalenciab90.models.WeatherError
import com.javalenciab90.networkmodels.dtos.weather.CurrentDTO
import com.javalenciab90.networkmodels.dtos.weather.ErrorDTO
import com.javalenciab90.networkmodels.dtos.weather.LocationDTO
import com.javalenciab90.networkmodels.dtos.weather.RequestDTO
import com.javalenciab90.networkmodels.dtos.weather.WeatherDTO
import com.javalenciab90.plataform.mapper.WeatherMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsLocalDataModule {

    @Binds
    abstract fun bindCurrentToEntityMapper(
        mapper: CurrentToEntityMapper
    ): WeatherMapper<Current, CurrentEntity>

    @Binds
    abstract fun bindLocationDtoToLocationMapper(
        mapper: LocationToEntityMapper
    ): WeatherMapper<Location, LocationEntity>

    @Binds
    abstract fun bindRequestToEntityMapper(
        mapper: RequestToEntityMapper
    ): WeatherMapper<Request, RequestEntity>

    @Binds
    abstract fun bindWeatherToEntityMapper(
        mapper: LocalMapper
    ): WeatherMapper<Weather, WeatherEntity>

}