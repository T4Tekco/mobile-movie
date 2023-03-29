package com.android.t4tek.data.repository

import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.remote.response.MoviesResponse
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val apiHelper: ApiHelper
): MovieRepository{
    override suspend fun getMovies(): List<JsonMovie> {
        val response = apiHelper.getMovies()
        if (response.isSuccessful) {
            val moviesResponse = response.body() as MoviesResponse
            return moviesResponse.jsonMovies;
        }
        return emptyList()
    }

    override suspend fun saveMovieDb(movie: List<JsonMovie>): List<MovieEntity> {
        val list = movie.map { it.toEntity()}.toList()
        db.moiveDao().inserAll(*list.toTypedArray())
        val  dbList = db.moiveDao().getAll()
        return dbList
    }
}