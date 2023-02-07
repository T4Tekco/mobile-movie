package com.android.t4tek.data.remote

import com.android.t4tek.data.local.entity.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}