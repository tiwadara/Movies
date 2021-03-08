package com.tiwa.movies.ui.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tiwa.common.model.Movie
import com.tiwa.common.repository.MovieRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val repository: MovieRepositoryImpl): ViewModel() {

    fun getMovie(movieId: Int): LiveData<Movie> {
       return  repository.getMovie(movieId)
    }
}