package com.android.t4tek.data.remote

import androidx.annotation.WorkerThread
import com.android.t4tek.data.remote.response.MoviesResponse
import com.android.t4tek.data.remote.response.PeopleResponse
import com.android.utils.NetworkHelper
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val apiService: ApiService
) : ApiHelper {
    @WorkerThread
    override suspend fun getMovies(): Response<MoviesResponse> {
        return safeApiCall { apiService.getMovies() }
    }

    @WorkerThread
    suspend fun <T> safeApiCall(callFunction: suspend () -> T): T {
        return if (networkHelper.isNetworkConnected())
            try {
                val myObject = callFunction.invoke()
                myObject
            } catch (e: Exception) {
                Timber.e(e)
                when (e) {
                    is HttpException -> {
                        throw Exception("something_wrong_happened")
                    }
                    else -> {
                        throw e
                    }
                }
            }
        else {
            throw UnknownHostException(
                "msg_error_connection"
            )
        }

    }

    override suspend fun getUsers(): Response<PeopleResponse> {
        return safeApiCall { apiService.getUsers() }
    }
}