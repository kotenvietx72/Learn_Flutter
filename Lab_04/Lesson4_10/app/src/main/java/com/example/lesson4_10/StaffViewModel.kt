package com.example.lesson4_10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StaffViewModel : ViewModel()  {
    private val _staff = MutableLiveData<List<Staff>>()
    val staff: LiveData<List<Staff>> = _staff

    init{
        _staff.value = listOf()
    }

    fun addStaff(staff: Staff) {
        val currentList = _staff.value.orEmpty().toMutableList()
        currentList.add(staff)
        _staff.value = currentList
    }
}