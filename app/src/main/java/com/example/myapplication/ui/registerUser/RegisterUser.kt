package com.example.myapplication.ui.registerUser

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.components.CustomTextFieldClasic

@Composable
fun RegisterUser(navController: NavController) {
    var fullname by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var passwordRepeat by remember {mutableStateOf("")}
    var isChecked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(30.dp)
            .background(Color.White),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TITULO
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Create your account",
                style = MaterialTheme.typography.titleLarge)
            Text("Join Sudapass and start using your",
                color = Color.Gray)
            Text("Digital identity",
                color = Color.Gray)
        }
        //FORMULARIO
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextFieldClasic(
                value = fullname,
                onValueChange = {
                },
                label = "Full name",
                placeholder = "Enter your full name",
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldClasic(
                value = id,
                onValueChange = {
                },
                label = "National ID / passport",
                placeholder = "Enter your ID or passport number",
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldClasic(
                value = email,
                onValueChange = {
                },
                label = "Email",
                placeholder = "user@gmail.com",
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldClasic(
                value = password,
                onValueChange = {
                    password = it
                },
                label = "Password",
                placeholder = "Enter your password",
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldClasic(
                value = passwordRepeat,
                onValueChange = {
                    password = it
                },
                label = "Password repeat",
                placeholder = "Enter your password",
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(), // Obligatorio para que se expanda y empuje los extremos
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clickable { isChecked = !isChecked }, //hace que todo el reglon sea clickeable
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }
                    )
                    Text(text = "I accept")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text("Privacy policy & Terms of Use",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            //código para ir a la otra pantalla aquí
                        })
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                onClick = {  }) {
                Text("Create account")
            }
            Spacer(modifier = Modifier.height(16.dp))
            //PIE DE PAGINA REGISTRARSE
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Already have an account?",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall,)

                Spacer(modifier = Modifier.width(10.dp))

                Text("Sign in",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                       navController.navigate("mainlogin")
                    })
            }
        }
    }

}