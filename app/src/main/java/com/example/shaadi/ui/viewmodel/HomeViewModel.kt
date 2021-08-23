package com.example.shaadi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shaadi.data.entities.UserResult
import com.example.shaadi.data.repository.UserRepository
import com.example.shaadi.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var usersList = repository.getAllUsers()


    fun accept(user: UserResult) {
        viewModelScope.launch {
            user.connection.isUpdated = true
            user.connection.connectionStatus = Constant.ACCEPTED
            user.connection.updatedAt = System.currentTimeMillis()
            repository.update(user)
        }
    }

    fun decline(user: UserResult) {
        viewModelScope.launch {
            user.connection.isUpdated = true
            user.connection.connectionStatus = Constant.DECLINED
            user.connection.updatedAt = System.currentTimeMillis()
            repository.update(user)
        }
    }


}
