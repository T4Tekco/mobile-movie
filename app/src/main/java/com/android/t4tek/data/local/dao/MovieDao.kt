package com.android.t4tek.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.data.remote.response.MoviesResponse

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getAll(): List<MovieEntity>

    @Insert
    fun inserAll(vararg movie: MovieEntity)

    @Query("DELETE FROM Movie")
    fun clearData()
}