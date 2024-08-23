package com.example.practice001

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewUser : ViewModel() {
    var dateUser by mutableStateOf(User())

    fun updateFullName(input: String) {
        dateUser = dateUser.copy(
            fullName = input
        )
    }

    fun updateGender(input: String) {
        dateUser = dateUser.copy(
            gender = input
        )
    }

    fun updatePhone(input: String) {
        dateUser = dateUser.copy(
            phone = input
        )
    }

    fun updateAddress(input: String) {
        dateUser = dateUser.copy(
            address = input
        )
    }

    fun registerUser(): User {
        return User(dateUser.fullName, dateUser.gender, dateUser.phone, dateUser.address)
    }
}
