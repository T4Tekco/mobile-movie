package com.android.t4tek.data.api

import com.android.t4tek.data.local.entity.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor() : ApiHelper {
    override suspend fun getUsers(): Response<List<User>> {
        TODO("Not yet implemented")
    }
}