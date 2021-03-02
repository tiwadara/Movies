package com.tiwa.movies.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiwa.common.model.Movie
import com.tiwa.common.repository.MovieRepositoryImpl
import com.tiwa.common.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor( private val repository: MovieRepositoryImpl): ViewModel() {

    private var movieList: LiveData<List<Movie>> = repository.getMovieList()
    private var isLoading: LiveData<Boolean> = repository.isLoading()
    init {
        getMovies()
    }

    fun getMovies(): LiveData<List<Movie>> {
        viewModelScope.launch {
            val response = repository.loadMovies()
            if (response.status == Status.SUCCESS){
                viewModelScope.launch {
                    repository.saveNewMovies(response.data?.results)
                    repository.stopLoading()
                }

            }
        }
        return movieList
    }

    fun getIsLoading(): LiveData<Boolean> {
        return isLoading
    }
}