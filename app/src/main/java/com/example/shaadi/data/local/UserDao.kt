package com.example.shaadi.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shaadi.data.entities.UserResult

@Dao
interface UserDao {

    @Query("SELECT * FROM UserResult")
    fun getAllUsersDB() : LiveData<List<UserResult>>

    @Query("SELECT * FROM UserResult WHERE _id = :id")
    fun getUserResult(id: Int): LiveData<UserResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: List<UserResult>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserResult)

    @Update
    suspend fun updateUserData(user: UserResult)



}