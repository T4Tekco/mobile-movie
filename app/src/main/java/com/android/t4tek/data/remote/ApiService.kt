package com.android.t4tek.data.remote

import com.android.t4tek.data.remote.response.MoviesResponse
import com.android.t4tek.data.remote.response.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("astros.json")
    suspend fun getUsers(): Response<PeopleResponse>

    @GET("/json/moviesData.json")
    suspend fun getMovies():Response<MoviesResponse>
}