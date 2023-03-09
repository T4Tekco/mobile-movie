package com.example.demoapi_7.api

import com.example.demoapi_7.model.Movies

interface MoviesApi {
    suspend fun getMovies(): Movies
}