package com.tiwa.movies.di

import android.content.Context
import androidx.room.Room
import com.tiwa.movies.data.constant.Constants
import com.tiwa.movies.data.dao.MovieDao
import com.tiwa.movies.data.dao.MovieDatabase
import com.tiwa.movies.data.repository.DefaultMovieRepository
import com.tiwa.movies.data.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room
            .databaseBuilder(
                context,
                MovieDatabase::class.java,
                MovieDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieDao: MovieDao,
        movieApi: MovieService,
    ): DefaultMovieRepository{
        return DefaultMovieRepository(movieDao,movieApi)
    }

    @Singleton
    @Provides
    fun provideMovieApi(): MovieService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(MovieService::class.java)
    }


}

