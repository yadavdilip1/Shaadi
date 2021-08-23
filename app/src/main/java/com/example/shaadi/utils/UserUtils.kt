package com.example.shaadi.utils

import com.example.shaadi.data.entities.UserResult


object UserUtils {

    @JvmStatic
    fun getPersonName(userResult: UserResult): String {
        val gender = when {
            userResult.gender.equals("male", true) -> {
                "M - "
            }
            userResult.gender.equals("female", true) -> {
                "F - "
            }
            else -> {
                ""
            }
        }

        return "${userResult.name.title.trim()}. ${userResult.name.first.trim()} ${userResult.name.last.trim()}\n($gender${userResult.dob.age})"
    }

    @JvmStatic
    fun getPersonLocation(userResult: UserResult) =
        "${userResult.location.city}, ${userResult.location.country}, ${userResult.location.state}-${userResult.location.postcode}"

    @JvmStatic
    fun getUpdatedStatus(userResult: UserResult): String {
        val isUpdate = userResult.connection.isUpdated
        if (isUpdate) {
            return if (userResult.connection.connectionStatus == Constant.ACCEPTED) {
                "Accepted on ${DateUtil.getStandardTime(userResult.connection.updatedAt)}"
            } else {
                "Declined on ${DateUtil.getStandardTime(userResult.connection.updatedAt)}"
            }
        }
        return ""
    }

}