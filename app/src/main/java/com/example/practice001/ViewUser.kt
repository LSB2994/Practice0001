package com.example.practice001

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewUser : ViewModel() {
    var dateUser by mutableStateOf(User())

    fun UpdateFullName(input:String){
        dateUser = dateUser.copy(
            fullName = input
        )
    }

    fun UpdateGender(input: String){
        dateUser = dateUser.copy(
            gender = input
        )
    }

    fun UpdatePhone(input: String){
        dateUser = dateUser.copy(
            phone = input
        )
    }

    fun UpdateAddress(input: String){
        dateUser = dateUser.copy(
            address = input
        )
    }

    fun RegisterUser():User{
        return User(dateUser.fullName,dateUser.gender,dateUser.phone,dateUser.address)
    }
}
