package com.example.demoapi_7.retrofit

import com.example.demoapi_7.api.MoviesApi
import com.example.demoapi_7.model.Movies
import retrofit2.http.GET

interface RetrofitApi : MoviesApi {
    @GET("/json/moviesData.json")
    override suspend fun getMovies(): Movies
}