package com.tiwa.common.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tiwa.common.constant.Constants.ERROR_MESSAGE
import com.tiwa.common.constant.Constants.NO_INTERNET_ERROR
import com.tiwa.common.dao.MovieDao
import com.tiwa.common.model.ApiResponse
import com.tiwa.common.model.Movie
import com.tiwa.common.service.MovieService
import com.tiwa.common.util.ResponseWrapper
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private var movieDao: MovieDao,
    private val movieService: MovieService,) : MovieRepository {

    private var isLoading = MutableLiveData<Boolean>()
    private lateinit var  movieList: LiveData<List<Movie>>
    private lateinit var  movie: LiveData<Movie>

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

    override fun getMovie(movieId: Int): LiveData<Movie> {
        movie =  movieDao.getMovie(movieId)
        return movie
    }

    override fun getMovie(): LiveData<Movie> {
        return movie
    }

    override  suspend fun loadMovies(): ResponseWrapper<ApiResponse> {
        return try {
            loading()
            val response = movieService.getMovies()
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let  ResponseWrapper.success(it)
                } ?: ResponseWrapper.error(ERROR_MESSAGE, null)
            } else {
                loaded()
                ResponseWrapper.error(ERROR_MESSAGE, null)
            }
        } catch(e: Exception) {
            loaded()
            ResponseWrapper.error(NO_INTERNET_ERROR, null)
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
