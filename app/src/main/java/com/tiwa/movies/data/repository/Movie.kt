package com.tiwa.movies.data.repository

import com.tiwa.movies.data.model.ApiResponse
import com.tiwa.movies.util.ResponseWrapper

interface Movie {
    suspend fun loadMovies(): ResponseWrapper<ApiResponse>
}