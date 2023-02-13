package com.android.t4tek.domain.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.android.t4tek.data.local.entity.User
import com.android.t4tek.domain.model.Person
import com.android.t4tek.domain.result_handler.DataResult

interface UserRepository {
    fun showLog()
    @WorkerThread
    fun insertRandomRecord()
    suspend fun getUsers():DataResult<List<Person>>
}