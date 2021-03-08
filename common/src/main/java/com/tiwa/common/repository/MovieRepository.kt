package com.tiwa.common.repository

import androidx.lifecycle.LiveData
import com.tiwa.common.model.ApiResponse
import com.tiwa.common.model.Movie
import com.tiwa.common.util.ResponseWrapper


interface MovieRepository {
    fun isLoading(): LiveData<Boolean>
    suspend fun loadMovies(): ResponseWrapper<ApiResponse>
    suspend fun saveNewMovies(movies: List<Movie>?)
    fun getMovieList(): LiveData<List<Movie>>
    fun stopLoading()
    fun getMovie(movieId: Int): LiveData<Movie>
    fun getMovie(): LiveData<Movie>
}