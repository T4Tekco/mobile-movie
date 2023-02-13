package com.android.t4tek.data.remote.response

import androidx.annotation.Keep
import com.android.t4tek.domain.model.Person
import com.squareup.moshi.Json
@Keep
data class PeopleResponse(
    @Json(name = "message") val message: String,
    @Json(name = "people") val peoples: List<Person>,
    @Json(name = "number") val number: Int
){
    fun isSuccess():Boolean{
        return message == "success"
    }
}