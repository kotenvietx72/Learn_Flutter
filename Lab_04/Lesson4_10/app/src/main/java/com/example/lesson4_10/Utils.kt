package com.example.lesson4_10

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object Utils {
    private const val format = "dd/mm/yyyy"

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat(format)

    fun StringToDate(date: String): Date {
        return try{
            formatter.parse(date)!!
        } catch (e: Exception) {
            Date()
        }
    }

    fun DateToString(date: Date): String {
        return formatter.format(date)
    }
}