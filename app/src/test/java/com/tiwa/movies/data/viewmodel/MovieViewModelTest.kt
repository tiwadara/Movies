package com.tiwa.movies.data.viewmodel

import androidx.lifecycle.Observer
import com.tiwa.common.dao.MovieDao
import com.tiwa.common.model.Movie
import com.tiwa.common.service.MovieService
import com.tiwa.common.repository.DefaultMovieRepository
import com.tiwa.movies.ui.movies.MovieViewModel
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`


@RunWith(JUnit4::class)
class MovieViewModelTest {

    private lateinit var  viewModel: MovieViewModel
    @Mock
    private lateinit var movieObserver: Observer<List<Movie>?>

    @Mock
    private lateinit var repository: DefaultMovieRepository
    @Mock
    private lateinit var movieDao: MovieDao
    @Mock
    private lateinit var movieApi: MovieService

    @Before
    fun setup(){
        repository = DefaultMovieRepository(movieDao , movieApi )
//        movieDao = MovieDao()
        viewModel = MovieViewModel(repository)
        viewModel = MovieViewModel(repository)
        viewModel.getMovies().observeForever(movieObserver)

    }

    @Test
    fun testNull() {
        `when`(repository.getMovieList()).thenReturn(null)
        assertNotNull(viewModel.getMovies())
        assertNotNull(viewModel.getMovies())
        assertTrue(viewModel.getMovies().hasObservers())
    }



}