package com.example.shaadi.di

import android.content.Context
import androidx.room.Room
import com.example.shaadi.data.local.UserDatabase
import com.example.shaadi.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDataBaseModule {

    @Provides
    @Singleton
    fun provideUserDataBase(@ApplicationContext appContext: Context)= Room.databaseBuilder(appContext, UserDatabase::class.java, Constant.ROOM_DATABASE_NAME)
        .build()

    @Provides
    @Singleton
    fun provideUserDetailsDao(userDataBase: UserDatabase)=userDataBase.userDetailDao()

}