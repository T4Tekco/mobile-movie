package com.android.t4tek.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.android.t4tek.data.json_model.Cast

@Entity(tableName = "Movie")
class MovieEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    @ColumnInfo(name = "movie")
    var movie: String? = ""
    @ColumnInfo(name = "year")
    var year: Long? = null
    @ColumnInfo(name = "rating")
    var rating: Double? = null
    @ColumnInfo(name = "duration")
    var duration: String? = ""
    @ColumnInfo(name = "director")
    var director: String? = ""
    @ColumnInfo(name = "tagline")
    var tagline: String? = ""
    @ColumnInfo(name = "image")
    var image: String? = ""
    @ColumnInfo(name = "story")
    var story: String? = ""
    @Ignore
    var cast: List<Cast>? =null


}
