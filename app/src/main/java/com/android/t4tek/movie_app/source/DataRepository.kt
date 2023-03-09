package com.example.demoapi_7.source


import com.example.demoapi_7.api.MoviesApi
import com.example.demoapi_7.model.Movies

class DataRepository(private val moviesApi: MoviesApi) {
    suspend fun getMovies() : Movies {
        return moviesApi.getMovies()
    }
}