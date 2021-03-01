package com.tiwa.movies

import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.tiwa.movies.data.dao.MovieDao
import com.tiwa.movies.data.dao.MovieDatabase
import com.tiwa.movies.data.model.Movie
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var database: MovieDatabase
    private lateinit var dao: MovieDao


    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MovieDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.movieDao()


    }

    @Test
    fun getIsLoading() {

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