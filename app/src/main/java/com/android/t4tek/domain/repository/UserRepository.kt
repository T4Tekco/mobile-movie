package com.android.t4tek.domain.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.android.t4tek.data.local.entity.User

interface UserRepository {
    fun showLog()
    @WorkerThread
    fun insertRandomRecord()
    suspend fun getUsers():List<User>
}