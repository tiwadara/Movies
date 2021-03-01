package com.tiwa.common.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tiwa.common.model.Movie
import com.tiwa.common.typeconverter.GenreTypeConverter


@Database(entities = [ Movie::class], version = 3, exportSchema = false)
@TypeConverters(GenreTypeConverter::class)

abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}




