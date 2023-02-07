package com.android.t4tek.data.api

import com.android.t4tek.data.local.entity.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}