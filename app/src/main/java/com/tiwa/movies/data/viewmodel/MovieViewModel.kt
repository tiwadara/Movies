package com.tiwa.movies.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiwa.movies.data.model.Movie
import com.tiwa.movies.data.repository.DefaultMovieRepository
import com.tiwa.movies.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: DefaultMovieRepository
): ViewModel() {

    private var movieList: LiveData<List<Movie>> = repository.movieList
    private var isLoading: LiveData<Boolean> = repository.isLoading
    init {
        getMovies()
    }

    fun getMovies(): LiveData<List<Movie>> {
        viewModelScope.launch {
            val response = repository.loadMovies()
            if (response.status == Status.SUCCESS){
                viewModelScope.launch {
                    repository.saveNewMovies(response.data?.results)
                    repository.loaded()
                }

            }
        }
        return movieList
    }

    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }
}