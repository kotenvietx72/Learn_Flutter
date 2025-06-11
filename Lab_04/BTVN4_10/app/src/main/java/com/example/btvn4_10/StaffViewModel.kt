package com.example.btvn4_10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StaffViewModel : ViewModel() {
    private val _staff = MutableLiveData<MutableList<Staff>>()
    val staff: LiveData<MutableList<Staff>> = _staff

    init {
        _staff.value = mutableListOf()
    }

    fun addStaff(staff: Staff) {
        var currentList = _staff.value ?: mutableListOf()
        currentList.add(staff)
        _staff.value = currentList
    }
}