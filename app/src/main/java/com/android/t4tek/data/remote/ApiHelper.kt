package com.android.t4tek.data.remote

import com.android.t4tek.data.local.entity.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}