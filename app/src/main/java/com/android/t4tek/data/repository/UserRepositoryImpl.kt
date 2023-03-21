package com.android.t4tek.data.repository

import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.remote.response.PeopleResponse
import com.android.t4tek.data.entity.PersonEntity
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.data.json_model.JsonPerson
import com.android.t4tek.data.remote.ApiHelperImpl
import com.android.t4tek.data.remote.response.MoviesResponse
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val apiHelper: ApiHelperImpl
) : UserRepository, BaseRepository() {
    override suspend fun getMovies(): List<JsonMovie> {
        val response = apiHelper.getMovies()
        if (response.isSuccessful) {
            val moviesResponse = response.body() as MoviesResponse
            return moviesResponse.jsonMovies;
        }
        return emptyList()
    }


    override suspend fun savePersonsToDb(persons: List<JsonPerson>): List<PersonEntity> {
            val list = persons.map {  it.toEntity()}.toList()
            db.personDao().insertAll(*list.toTypedArray())
            val dbList = db.personDao().getAll()
            return dbList
    }

}