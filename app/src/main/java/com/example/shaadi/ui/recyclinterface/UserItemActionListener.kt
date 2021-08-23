package com.example.shaadi.ui.recyclinterface

import com.example.shaadi.data.entities.UserResult

interface UserItemActionListener {

    fun onAcceptButtonClick(user: UserResult)
    fun onIgnoreButtonClick(user: UserResult)

}