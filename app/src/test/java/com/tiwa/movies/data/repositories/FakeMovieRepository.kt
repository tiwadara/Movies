package com.tiwa.movies.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tiwa.common.model.ApiResponse
import com.tiwa.common.model.Dates
import com.tiwa.common.model.Movie
import com.tiwa.data.api.repository.MovieRepository
import com.tiwa.common.util.ResponseWrapper

class FakeMovieRepository : MovieRepository {

    private val movieList = mutableListOf<Movie>()

    private val observableMovieList = MutableLiveData<List<Movie>>(movieList)

    private fun refreshLiveData() {
        observableMovieList.postValue(movieList)
    }
    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override fun isLoading(): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun loadMovies(): ResponseWrapper<ApiResponse> {
        return if(shouldReturnNetworkError) {
            ResponseWrapper.error("Error", null)
        } else {
            ResponseWrapper.success(ApiResponse(Dates("",""), 0,listOf(), 0, 0))
        }
    }

    override suspend fun saveNewMovies(movies: List<Movie>?) {
        TODO("Not yet implemented")
    }

    override fun getMovieList(): LiveData<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun stopLoading() {
        TODO("Not yet implemented")
    }


}

