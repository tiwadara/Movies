package com.tiwa.movies.data.repositories

import androidx.lifecycle.MutableLiveData

class FakeMovieRepository : com.tiwa.movies.data.repository.Movie {

    private val movieList = mutableListOf<Movie>()

    private val observableMovieList = MutableLiveData<List<Movie>>(movieList)

    private fun refreshLiveData() {
        observableMovieList.postValue(movieList)
    }

    override fun getMovieListUpdateFromServer() {
        refreshLiveData()
    }
}

