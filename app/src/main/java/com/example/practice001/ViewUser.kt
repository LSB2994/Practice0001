package com.example.practice001
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewUser:ViewModel(){
    var fullName by mutableStateOf("")
    var gender by mutableStateOf("")
    var phone by mutableStateOf("")
    var address by mutableStateOf("")

    fun RegisterUser():User{
        return User(fullName,gender,phone,address)
    }
}
