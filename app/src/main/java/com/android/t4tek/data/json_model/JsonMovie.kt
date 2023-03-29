package com.android.t4tek.data.json_model


import com.android.t4tek.data.entity.MovieEntity


data class JsonMovie (
    val movie: String,
    val year: Long,
    val rating: Double,
    val duration: String,
    val director: String,
    val tagline: String,
    val cast: List<Cast>,
    val image: String,
    val story: String
){
    fun toEntity():MovieEntity{
        val movieEntity = MovieEntity()
        movieEntity.movie = movie
        movieEntity.year = year
        movieEntity.image = image
        movieEntity.story = story
        movieEntity.rating = rating
        movieEntity.duration = duration
        movieEntity.director = director
        movieEntity.tagline = tagline
        movieEntity.cast = cast
        return movieEntity
    }
}

data class Cast (
    val name: String
)
