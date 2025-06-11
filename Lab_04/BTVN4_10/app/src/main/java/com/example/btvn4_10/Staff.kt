package com.example.btvn4_10

data class Staff(private val StaffId: String, private val FullName: String, private val BirthDate: String, private val Salary: Float){
    override fun toString(): String {
        return "$StaffId - $FullName - $BirthDate - $Salary"
    }
}
