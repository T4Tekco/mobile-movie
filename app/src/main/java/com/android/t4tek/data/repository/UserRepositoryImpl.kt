package com.android.t4tek.data.repository

import android.util.Log
import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.local.entity.User
import com.android.t4tek.domain.BaseRepository
import com.android.t4tek.domain.repository.UserRepository
import javax.inject.Inject
import java.util.Random

class UserRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val apiHelper: ApiHelper
) : UserRepository, BaseRepository() {
    override fun showLog() {
        insertRandomRecord()
    }

    override fun insertRandomRecord() {
        val random = Random()
        val randomInt = random.nextInt()
        val user = User(randomInt, "firstName $random", "lastName $randomInt")
        db.userDao().insertAll(user)
    }

    override suspend fun getUsers(): List<User> {
        return apiHelper.getUsers().body() ?: emptyList()
    }
}