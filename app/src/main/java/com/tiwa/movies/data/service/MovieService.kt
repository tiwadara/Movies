package com.tiwa.movies.data.service

import com.tiwa.movies.data.constant.Constants
import com.tiwa.movies.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieService {
    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("movie/upcoming?api_key=${Constants.API_KEY}&language=en-US&page=1")
    suspend fun getMovies(): Response<ApiResponse>
}