package com.javalenciab90.data.di

import com.javalenciab90.data.datasource.remote.WeatherRemoteData
import com.javalenciab90.data.datasource.remote.WeatherRemoteDataImpl
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
import com.javalenciab90.service.api.WeatherService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideRestApiService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    fun bindsWeatherRemoteData(
        weatherService: WeatherService,
        networkMapper: NetworkMapper
    ) : WeatherRemoteData {
        return WeatherRemoteDataImpl(
            weatherService, networkMapper
        )
    }
}

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
