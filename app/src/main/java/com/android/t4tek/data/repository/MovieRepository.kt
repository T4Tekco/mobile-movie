package com.android.t4tek.data.repository

import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.json_model.JsonMovie

interface MovieRepository {
    suspend fun getMovies(): List<JsonMovie>
    suspend fun saveMovieDb(movie: List<JsonMovie>) : List<MovieEntity>
}