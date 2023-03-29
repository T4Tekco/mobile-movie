package com.android.t4tek.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.local.dao.MovieDao

//@Database(entities = [MovieEntity::class], version = 1)
//abstract class MovieDatabase : RoomDatabase() {
//    abstract fun movieDao() : MovieDao
//
//    companion object{
//
//        private var instance: MovieDatabase? = null
//
//        fun getDatabase(context: Context): MovieDatabase{
//            return instance?: synchronized(this){
//                var ins = Room.databaseBuilder(
//                    context.applicationContext,
//                    MovieDatabase::class.java,
//                    "movie.db"
//                ).build()
//                instance = ins
//                ins
//            }
//        }
//    }
//}