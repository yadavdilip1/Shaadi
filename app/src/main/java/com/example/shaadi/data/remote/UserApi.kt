package com.example.shaadi.data.remote

import com.example.shaadi.data.entities.UserResponse
import com.example.shaadi.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET(".")
    suspend fun getAllUsers(@Query("results") responseCount: Int = Constant.USER_REPONSE_SIZE): Response<UserResponse>
}