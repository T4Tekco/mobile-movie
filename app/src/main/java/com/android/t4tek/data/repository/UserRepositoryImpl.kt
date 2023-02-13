package com.android.t4tek.data.repository

import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.local.entity.User
import com.android.t4tek.data.remote.response.PeopleResponse
import com.android.t4tek.domain.BaseRepository
import com.android.t4tek.domain.model.Person
import com.android.t4tek.domain.repository.UserRepository
import com.android.t4tek.domain.result_handler.AppErrorType
import com.android.t4tek.domain.result_handler.DataResult
import timber.log.Timber
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

    override suspend fun getUsers(): DataResult<List<Person>> {
        try {
            Timber.tag("UserRepositoryImpl").i("getUsers")
            val response = apiHelper.getUsers()
            Timber.tag("UserRepositoryImpl").i("response1: ${response}")
            if (response.isSuccessful) {
                Timber.tag("UserRepositoryImpl").i("response2: ${response.body()}")
                val peopleResponse = response.body() as PeopleResponse
                if (peopleResponse.isSuccess()) {
                    Timber.tag("UserRepositoryImpl").i("response3: ${peopleResponse.peoples}")
                    return DataResult.resultSuccess(peopleResponse.peoples)
                }
            }
            return DataResult.resultSuccess(emptyList())
        } catch (ex: Exception) {
            Timber.tag("UserRepositoryImpl").i("ex: ${ex}")
            return DataResult.resultError(AppErrorType.FetchApiException, errorMessage = ex.message)
        }

    }
}