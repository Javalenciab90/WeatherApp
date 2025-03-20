package com.javalenciab90.data.di

import com.javalenciab90.data.mappers.CurrentDtoToCurrentMapper
import com.javalenciab90.data.mappers.LocationDtoToLocationMapper
import com.javalenciab90.data.mappers.NetworkErrorMapper
import com.javalenciab90.data.mappers.NetworkMapper
import com.javalenciab90.data.mappers.RequestDtoToRequestMapper
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
abstract class BindsRemoteDataModule {

    @Binds
    abstract fun bindNetworkErrorToWeatherErrorMapper(
        mapper: NetworkErrorMapper
    ): WeatherMapper<ErrorDTO, WeatherError>

    @Binds
    abstract fun bindCurrentDtoToCurrentMapper(
        mapper: CurrentDtoToCurrentMapper
    ): WeatherMapper<CurrentDTO, Current>

    @Binds
    abstract fun bindLocationDtoToLocationMapper(
        mapper: LocationDtoToLocationMapper
    ): WeatherMapper<LocationDTO, Location>

    @Binds
    abstract fun bindRequestDtoToRequestMapper(
        mapper: RequestDtoToRequestMapper
    ): WeatherMapper<RequestDTO, Request>

    @Binds
    abstract fun bindWeatherNetworkToEntityMapper(
        mapper: NetworkMapper
    ): WeatherMapper<WeatherDTO, Weather>

}