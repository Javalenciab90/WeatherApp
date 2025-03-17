package com.javalenciab90.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.javalenciab90.data.room.entities.WeatherEntity
import com.javalenciab90.data.room.typeconverters.Converters

@Database(entities = [WeatherEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}