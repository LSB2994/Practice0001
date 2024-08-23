package com.example.practice001

import android.view.View
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextField(
    value: String,
    onValueChange: (text:String) -> Unit,
    holder: String,
    label: String,
    vm:ViewUser,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = when (value) {
            "fullname" -> {
                vm.dateUser.fullName
            }
            "gender" -> {
                vm.dateUser.gender
            }
            "phone" -> {
                vm.dateUser.phone
            }
            else -> vm.dateUser.address
        }
            ,
        onValueChange = {
            onValueChange(it)
        },
        placeholder = { Text(text = holder) },
        label = { Text(text = label) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType =  if (value == "phone") KeyboardType.Phone else KeyboardType.Text
        ),
    )
}