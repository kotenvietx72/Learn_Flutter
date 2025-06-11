package com.example.lesson4_10

import java.util.Date

data class Staff(
    var staffId: String = "",
    var fullName: String = "",
    var birthDate: Date = Date(),
    var salary: Long = 0
) {
    override fun toString(): String {
        return "$staffId - $fullName - ${Utils.DateToString(birthDate)} - $salary"
    }
}
