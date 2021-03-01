package com.tiwa.movies.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tiwa.movies.data.dao.MovieDao
import com.tiwa.movies.data.model.ApiResponse
import com.tiwa.movies.data.model.Movie
import com.tiwa.movies.data.service.MovieService
import com.tiwa.movies.util.ResponseWrapper
import javax.inject.Inject


class DefaultMovieRepository @Inject constructor(
    private var movieDao: MovieDao,
    private val movieApi: MovieService,) : com.tiwa.movies.data.repository.Movie {
    var isLoading = MutableLiveData<Boolean>()
    lateinit var  movieList: LiveData<List<Movie>>

    init {
        loadCachedMovieList()
    }

    private fun loadCachedMovieList() {
        movieList = movieDao.getAllMovies()
    }

    override  suspend fun loadMovies(): ResponseWrapper<ApiResponse> {
        return try {
            loading()
            val response = movieApi.getMovies()
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let  ResponseWrapper.success(it)
                } ?: ResponseWrapper.error("An unknown error occured", null)
            } else {
                ResponseWrapper.error("An unknown error occured", null)
            }
        } catch(e: Exception) {
            loaded()
            ResponseWrapper.error("Couldn't reach the server. Check your internet connection", null)
        }
    }

    suspend  fun saveNewMovies(movies: List<Movie>?) {
        movieDao.insertAll(movies)
    }

    fun  loaded() {
        isLoading.value = false
    }

    fun  loading() {
        isLoading.value = true
    }

}
