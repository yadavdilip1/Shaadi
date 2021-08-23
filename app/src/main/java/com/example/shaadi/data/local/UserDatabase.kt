package com.example.shaadi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shaadi.data.entities.UserResult

@Database(entities = [UserResult::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDetailDao():UserDao
}