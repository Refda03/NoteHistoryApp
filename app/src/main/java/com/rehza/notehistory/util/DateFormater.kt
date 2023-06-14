package com.rehza.notehistory.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getDayFormat(dateString: String): String{
    if (dateString.isEmpty()) return ""
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return LocalDateTime.parse(dateString,formatter ).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
}