package com.tiwa.common.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class GenreTypeConverter {
    @TypeConverter
    fun toGenre(string: String?): List<Int>? {
        val listType: Type = object : TypeToken<List<Int?>?>() {}.type
        return if (string == null) null
        else Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun fromGenre(genre: List<Int>?): String? {
        return (if (genre == null) null else
            Gson().toJson(genre))
    }
}