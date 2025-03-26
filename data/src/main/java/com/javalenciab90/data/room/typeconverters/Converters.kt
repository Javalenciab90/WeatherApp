package com.javalenciab90.data.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.javalenciab90.data.room.entities.LocationEntity
import com.javalenciab90.data.room.entities.MainEntity
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.models.openweather.Location
import com.javalenciab90.models.openweather.Main
import com.javalenciab90.models.openweather.Weather

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromLocationEntity(location: LocationEntity?): String? {
        return gson.toJson(location)
    }

    @TypeConverter
    fun toLocationEntity(locationString: String?): LocationEntity? {
        return gson.fromJson(locationString, LocationEntity::class.java)
    }

    @TypeConverter
    fun fromMainEntity(main: MainEntity?): String? {
        return gson.toJson(main)
    }

    @TypeConverter
    fun toMainEntity(mainString: String?): MainEntity? {
        return gson.fromJson(mainString, MainEntity::class.java)
    }

    @TypeConverter
    fun fromWeatherEntity(weather: WeatherEntity?): String? {
        return gson.toJson(weather)
    }

    @TypeConverter
    fun toWeatherEntity(weatherString: String?): WeatherEntity? {
        return gson.fromJson(weatherString, WeatherEntity::class.java)
    }
}
