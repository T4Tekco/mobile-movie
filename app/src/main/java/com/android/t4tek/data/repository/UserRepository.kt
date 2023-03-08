package com.android.t4tek.data.repository

import androidx.annotation.WorkerThread
import com.android.t4tek.data.entity.PersonEntity
import com.android.t4tek.data.json_model.JsonPerson

interface UserRepository {

    suspend fun getPersonApi(): List<JsonPerson>
    suspend fun savePersonsToDb(persons: List<JsonPerson>): List<PersonEntity>
    suspend fun clearAllPerson(): Boolean
}