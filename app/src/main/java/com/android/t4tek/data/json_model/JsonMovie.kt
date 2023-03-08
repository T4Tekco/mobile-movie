package com.android.t4tek.data.json_model

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
)
data class Cast (
    val name: String
)