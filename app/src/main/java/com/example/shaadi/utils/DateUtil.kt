package com.example.shaadi.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun getStandardTime(timeStamp: Long): String {
        val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
        return sdf.format(timeStamp)
    }
}