package com.android.t4tek.domain.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class Person(
    @Json(name = "name") val name: String,
    @Json(name = "craft") val craft: String
)