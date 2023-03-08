package com.android.t4tek.data.remote.response

import androidx.annotation.Keep
import com.android.t4tek.data.json_model.JsonMovie
import com.squareup.moshi.Json

@Keep
data class MoviesResponse(
    @Json(name = "movies")
    val jsonMovies: List<JsonMovie>
)