package com.tiwa.common.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.tiwa.common.getOrAwaitValue
import com.tiwa.common.model.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class MovieDaoTest {

    @get:Rule
    var instantTasExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: MovieDatabase
    private lateinit var movieDao: MovieDao



    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDatabase::class.java
        ).allowMainThreadQueries().build()
        movieDao = database.movieDao()
    }

    @Test
    fun insertMovies() = runBlockingTest {
        val movieList = emptyList<Movie>()
        movieDao.insertAll(emptyList())
        movieDao.getAllMovies()
        val allMovies  = movieDao.getAllMovies().getOrAwaitValue()
        assertThat(allMovies.size).isEqualTo(movieList.size)
    }
}