package com.javalenciab90.data.di

import com.javalenciab90.data.mappers.GeoLocationNetworkMapper
import com.javalenciab90.data.mappers.LocationDtoToLocationMapper
import com.javalenciab90.data.mappers.MainDtoToMainMapper
import com.javalenciab90.data.mappers.WeatherDtoToWeatherMapper
import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationDTO
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationListDTO
import com.javalenciab90.networkmodels.dtos.openweather.LocationDTO
import com.javalenciab90.networkmodels.dtos.openweather.MainDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherDTO
import com.javalenciab90.plataform.mapper.GeoLocationMapper
import com.javalenciab90.plataform.mapper.WeatherMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsRemoteDataModule {

    @Binds
    abstract fun bindGeoLocationDtoToGeoLocationMapper(
        mapper: GeoLocationNetworkMapper
    ) : GeoLocationMapper<GeoLocationListDTO, GeoLocation>

    @Binds
    abstract fun bindWeatherDtoToWeatherMapper(
        mapper: WeatherDtoToWeatherMapper
    ) : WeatherMapper<List<WeatherDTO>, Weather>

    @Binds
    abstract fun bindLocationDtoToLocationMapper(
        mapper: LocationDtoToLocationMapper
    ) : WeatherMapper<LocationDTO, Location>

    @Binds
    abstract fun bindMainDtoToMainMapper(
        mapper: MainDtoToMainMapper
    ) : WeatherMapper<MainDTO, Main>

}