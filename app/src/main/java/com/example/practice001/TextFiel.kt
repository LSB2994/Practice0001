package com.example.practice001

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun TextField(
    value:String,
    onValueChange: (String)->Unit,
    holder:String,
    label:String,
    modifier: Modifier = Modifier,
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange ,
        placeholder = { Text(text = holder)},
        label = {Text(text = label)},
        modifier = modifier,
    )
}