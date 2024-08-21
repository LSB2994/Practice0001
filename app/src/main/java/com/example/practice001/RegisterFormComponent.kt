package com.example.practice001

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterForm(){
    val view : ViewUser = viewModel()
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp, 10.dp, 0.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(text = "Information",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(Icons.Rounded.AccountCircle, contentDescription  = stringResource(id = R.string.app_name))
        }

        TextField(
            value = view.fullName,
            onValueChange = {view.fullName = it},
            holder = "Leng Sambath",
            label = "Full name",
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Row(
            Modifier.padding(10.dp)
        ) {
            TextField(
                value = view.gender,
                onValueChange = {view.gender = it},
                holder = "Male",
                label = "Gender",
                Modifier.width(120.dp)

            )
            TextField(
                value = view.phone,
                onValueChange = {view.phone = it},
                holder = "095****60",
                label = "Phone",
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            )
        }
        TextField(
            value = view.address,
            onValueChange = {view.address = it},
            holder = "Phom Penh",
            label = "Address",
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        if (view.fullName.isNotEmpty() &&
            view.gender.isNotEmpty() &&
            view.phone.isNotEmpty() &&
            view.address.isNotEmpty()){
            Button(onClick = { view.RegisterUser()
            },
                Modifier
                    .fillMaxWidth(),
                enabled = true
                ) {
                Text(text = "Submit")
            }
        }else
            Button(onClick = { view.RegisterUser()
        },
            Modifier
                .fillMaxWidth(),
            enabled = false
        ) {
            Text(text = "Submit")
        }
    }
}