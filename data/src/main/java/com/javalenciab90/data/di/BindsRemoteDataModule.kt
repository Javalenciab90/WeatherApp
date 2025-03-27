package com.javalenciab90.data.di

import com.javalenciab90.data.mappers.GeoLocationDataMapper
import com.javalenciab90.data.mappers.LocationDtoToLocationMapper
import com.javalenciab90.data.mappers.MainDtoToMainMapper
import com.javalenciab90.data.mappers.WeatherDtoToDataMapper
import com.javalenciab90.models.geo.GeoLocation
import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather
import com.javalenciab90.networkmodels.dtos.geo.GeoLocationListDTO
import com.javalenciab90.networkmodels.dtos.openweather.LocationDTO
import com.javalenciab90.networkmodels.dtos.openweather.MainDTO
import com.javalenciab90.networkmodels.dtos.openweather.WeatherDTO
import com.javalenciab90.mapper.DataMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsRemoteDataModule {

    @Binds
    abstract fun bindGeoLocationDtoToGeoLocationMapper(
        mapper: GeoLocationDataMapper
    ) : DataMapper<GeoLocationListDTO, GeoLocation>

    @Binds
    abstract fun bindWeatherDtoToWeatherMapper(
        mapper: WeatherDtoToDataMapper
    ) : DataMapper<List<WeatherDTO>, Weather>

    @Binds
    abstract fun bindLocationDtoToLocationMapper(
        mapper: LocationDtoToLocationMapper
    ) : DataMapper<LocationDTO, Location>

    @Binds
    abstract fun bindMainDtoToMainMapper(
        mapper: MainDtoToMainMapper
    ) : DataMapper<MainDTO, Main>

}