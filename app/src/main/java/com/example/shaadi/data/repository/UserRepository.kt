package com.example.shaadi.data.repository

import com.example.shaadi.data.entities.UserResult
import com.example.shaadi.data.local.UserDao
import com.example.shaadi.data.remote.UsersRemoteDataSource
import com.example.shaadi.utils.performGetOperation
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val remoteDataSource: UsersRemoteDataSource,
    private val localDataSource: UserDao
) {

    fun getAllUsers() = performGetOperation(
        databaseQuery = { localDataSource.getAllUsersDB() },
        networkCall = { remoteDataSource.getAllUsersApi() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )

    suspend fun update(user: UserResult) = localDataSource.updateUserData(user)

}
