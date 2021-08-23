package com.example.shaadi.data.entities

import com.squareup.moshi.Json

data class UserResponse(

    @Json(name = "results")
    val results: List<UserResult>
)