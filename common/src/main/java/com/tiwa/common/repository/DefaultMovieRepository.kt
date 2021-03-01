package com.tiwa.common.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tiwa.common.dao.MovieDao
import com.tiwa.common.dao.MovieDatabase
import com.tiwa.common.model.ApiResponse
import com.tiwa.common.model.Movie
import com.tiwa.common.service.MovieService
import com.tiwa.common.util.ResponseWrapper
import javax.inject.Inject


class DefaultMovieRepository @Inject constructor(
    private var movieDao: MovieDao,
    private val movieService: MovieService,) : MovieRepository {

    private var isLoading = MutableLiveData<Boolean>()
    private lateinit var  movieList: LiveData<List<Movie>>

    init {
        loadCachedMovieList()
    }

    private fun loadCachedMovieList() {
        movieList = movieDao.getAllMovies()
    }

    override fun isLoading(): LiveData<Boolean> {
        return isLoading
    }

    override fun getMovieList(): LiveData<List<Movie>> {
        return movieList
    }

    override  suspend fun loadMovies(): ResponseWrapper<ApiResponse> {
        return try {
            loading()
            val response = movieService.getMovies()
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

    override  suspend  fun saveNewMovies(movies: List<Movie>?) {
        movieDao.insertAll(movies)
    }

    override fun stopLoading(){
        loaded()
    }

    private fun  loaded() {
        isLoading.value = false
    }

    private fun  loading() {
        isLoading.value = true
    }

}
