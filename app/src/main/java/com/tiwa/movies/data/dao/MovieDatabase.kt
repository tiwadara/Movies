package com.tiwa.movies.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tiwa.movies.data.model.Movie
import com.tiwa.movies.data.typeconverter.GenreTypeConverter
import kotlinx.coroutines.CoroutineScope


@Database(entities = [ Movie::class], version = 3, exportSchema = false)
@TypeConverters(GenreTypeConverter::class)

abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DATABASE_NAME: String = "movie_database.db"

        @Volatile
        private var INSTANCE: MovieDatabase? = null
        private var scope: CoroutineScope? = null

        fun getDatabase(context: Context, scope: CoroutineScope): MovieDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                this.scope = scope
                return instance

            }

        }
    }


}




