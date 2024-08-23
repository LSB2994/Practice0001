package com.example.practice001

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterForm() {
    val pattern = remember { Regex("\\d+") }
    val view: ViewUser = viewModel()
    Column(
        Modifier
            .fillMaxWidth()
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
            Text(
                text = "Information",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                Icons.Rounded.AccountCircle,
                contentDescription = stringResource(id = R.string.app_name)
            )
        }

        TextField(
            "fullname",
            { view.updateFullName(it) },
            "Leng Sambath",
            "Full name",
            view,
            Modifier
                .fillMaxWidth()
        )
        Row(
            Modifier.fillMaxWidth()
        ) {
            TextField(
                "gender", { view.updateGender(it) }, "Male", "Gender", view, Modifier.width(120.dp)
            )
            TextField(
                "phone",
                {
                    if (it.isEmpty() || it.matches(pattern)) {
                        view.updatePhone(it)
                    }
                },
                "095****60",
                "Phone",
                view,
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            )
        }
        TextField(
            "address",
            { view.updateAddress(it) },
            "Phom Penh",
            "Address",
            view,
            Modifier.fillMaxWidth()
        )
        if (view.dateUser.fullName.isNotEmpty() && view.dateUser.gender.isNotEmpty() && view.dateUser.phone.isNotEmpty() && view.dateUser.address.isNotEmpty()) {
            Button(
                onClick = {
                    view.registerUser()
                },
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp), enabled = true
            ) {
                Text(text = "Submit")
            }
        } else Button(
            onClick = {
                view.registerUser()
            },
            Modifier
                .fillMaxWidth()
                .padding(top = 10.dp), enabled = false
        ) {
            Text(text = "Submit")
        }
    }
}