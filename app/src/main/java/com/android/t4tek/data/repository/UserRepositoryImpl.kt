package com.android.t4tek.data.repository

import android.util.Log
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.local.entity.User
import com.android.t4tek.domain.repository.UserRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import java.util.Random
import javax.inject.Singleton

class UserRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : UserRepository {
    override fun showLog() {
        Log.i("hanhmh1203", "showLog")
        insertRandomRecord()
    }

    override fun insertRandomRecord() {
        val random = Random()
        val randomInt = random.nextInt()
        val user= User(randomInt, "firstName $random", "lastName $randomInt")
        db.userDao().insertAll(user)
    }
}