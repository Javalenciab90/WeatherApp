package com.javalenciab90.data.room.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.javalenciab90.data.room.entities.CurrentEntity
import com.javalenciab90.data.room.entities.LocationEntity
import com.javalenciab90.data.room.entities.RequestEntity

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromCurrentEntity(currentEntity: CurrentEntity): String {
        return gson.toJson(currentEntity)
    }

    @TypeConverter
    fun toCurrentEntity(currentEntityString: String): CurrentEntity {
        return gson.fromJson(currentEntityString, CurrentEntity::class.java)
    }

    @TypeConverter
    fun fromLocationEntity(locationEntity: LocationEntity): String {
        return gson.toJson(locationEntity)
    }

    @TypeConverter
    fun toLocationEntity(locationEntityString: String): LocationEntity {
        return gson.fromJson(locationEntityString, LocationEntity::class.java)
    }

    @TypeConverter
    fun fromRequestEntity(requestEntity: RequestEntity): String {
        return gson.toJson(requestEntity)
    }

    @TypeConverter
    fun toRequestEntity(requestEntityString: String): RequestEntity {
        return gson.fromJson(requestEntityString, RequestEntity::class.java)
    }
}