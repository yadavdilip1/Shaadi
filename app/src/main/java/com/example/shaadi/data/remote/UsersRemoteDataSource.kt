package com.example.shaadi.data.remote

import com.example.shaadi.utils.BaseDataSource
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(
    private val userApi: UserApi
) : BaseDataSource() {

    suspend fun getAllUsersApi() = getResult { userApi.getAllUsers() }

}