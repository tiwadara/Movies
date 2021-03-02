package com.tiwa.common.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.tiwa.common.dao.MovieDao
import com.tiwa.common.model.ApiResponse
import com.tiwa.common.model.Dates
import com.tiwa.common.model.Movie
import com.tiwa.common.service.MovieService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MovieRepositoryImplTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieRepository: MovieRepository

    private lateinit var movieService: MovieService
    private lateinit var movieDao: MovieDao


    private var movieListLiveData = MutableLiveData< List<Movie>>()
    lateinit var apiResponse: ApiResponse


    @Before
    fun setUp() {

        //Mocking movieDao
        movieDao = mock()
        movieListLiveData.postValue( listOf())
        whenever(movieDao.getAllMovies()).thenReturn(movieListLiveData)

        //Mocking movieService
        movieService = mock()
        apiResponse = ApiResponse(Dates(),0, listOf(), 0,0)
        movieRepository = MovieRepositoryImpl(movieDao, movieService)

    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadMovies_returnMoviesResponseWrapper() {
        runBlockingTest {
            whenever(movieService.getMovies()).thenReturn(Response.success(apiResponse))
            val result = movieRepository.loadMovies()
            assertEquals(result.data ,apiResponse )
        }
    }

    @Test
    fun isLoading() {
    }

    @Test
    fun getMovieList() {
    }

    @Test
    fun loadMovies() {
    }

    @Test
    fun saveNewMovies() {
    }

    @Test
    fun stopLoading() {
    }
}