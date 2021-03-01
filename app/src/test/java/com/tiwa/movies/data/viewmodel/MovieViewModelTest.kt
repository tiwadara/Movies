package com.tiwa.movies.data.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tiwa.movies.data.model.Movie
import com.tiwa.movies.data.repository.DefaultMovieRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieViewModelTest {

    @Mock
    private lateinit var movieViewModel: MovieViewModel

    @Mock
    private lateinit var application: Application

    @Mock
    private lateinit var movieRepository: DefaultMovieRepository



    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        val application  =  Mockito.mock(Application::class.java)
        val context  =  Mockito.mock(Context::class.java)
        Mockito.`when`(application.applicationContext).thenReturn(context)

        movieRepository = Mockito.mock(DefaultMovieRepository::class.java)
        movieViewModel = Mockito.spy(MovieViewModel(movieRepository))

    }

    @Test
    fun getIsLoading() {
        var movieList: MutableLiveData<List<Movie>>? = null
        movieList?.value = listOf<Movie>()
        movieViewModel = MovieViewModel(movieRepository)
        Mockito.`when`(movieRepository.movieList).thenReturn(movieList)
        assertEquals(true, movieViewModel.getIsLoading())
        assertEquals(false, movieViewModel.getIsLoading())

    }

    @Test
    fun getMovies() {
        var movieList: LiveData<List<Movie>>

    }

    @Test
    fun test_movies_view_model_data_populates_expected_value(){

//        val sampleResponse = getJson("success_resp_list.json")
//        var jsonObj = Gson().fromJson(sampleResponse, AllPeople::class.java)
//
//        //Make sure login use case returns expected response when called
//
//        coEvery { mLoginUseCase.processLoginUseCase(any()) } returns jsonObj
//        mLoginActivityViewModel.mAllPeopleResponse.observeForever {
//
//        }

//        vehicleViewModel.requestLoginActivityData(mParam)
//
//        assert(vehicleViewModel.mAllPeopleResponse.value != null)
//        assert(vehicleViewModel.mAllPeopleResponse.value!!.responseStatus == LiveDataWrapper.RESPONSESTATUS.SUCCESS)
//
//        val testResult = mLoginActivityViewModel.mAllPeopleResponse.value as LiveDataWrapper<AllPeople>
//        assertEquals(testResult.response!!.next,mNextValue)
    }

    @Test
    fun getSelectedPoi() {
    }

    @Test
    fun setSelected() {
    }
}