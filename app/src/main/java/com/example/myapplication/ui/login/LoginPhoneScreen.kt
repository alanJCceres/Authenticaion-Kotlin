package com.example.myapplication.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.ui.components.CustomTextFieldClasic
import com.example.myapplication.ui.components.PhoneNumberInput

@Composable
fun LoginPhoneScreen(
    onLoginSuccess: () -> Unit,
    onSignUp: () -> Unit,
    viewModel: LoginPhoneViewModel = viewModel()
) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var isChecked by remember { mutableStateOf(false) }
    // "Colectamos" el estado del ViewModel y lo convertimos en un State de Compose
    val state by viewModel.uiState.collectAsState()

    // Efecto lanzado cuando el estado de navegación cambia a true
    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect{
            onLoginSuccess()
        }
    }

    Column(
        modifier = Modifier
            .background(Color.White),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //FORMULARIO
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PhoneNumberInput(
                value=phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                label = "Phone Number",
                placeholder = "Enter your number"
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldClasic(
                value = password,
                onValueChange = {
                    password = it
                },
                label = "Password",
                placeholder = "Enter your password",
                isError = state.mostrarError != null,
                errorMessage = state.mostrarError
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
                    Text(text = "Remember me")
                }
                Text("Forgot password?",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        onLoginSuccess()
                    })
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                onClick = { onLoginSuccess()}
            ) {
                Text("Sign in")
            }

            //LINEA SEPARADORA
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically // Centra las líneas con el texto verticalmente
            ) {
                // 1. Línea izquierda
                HorizontalDivider(
                    modifier = Modifier.weight(1f), // Se expande para ocupar el lado izquierdo
                    thickness = 1.dp,
                    color = Color.Gray.copy(alpha = 0.5f) // Color tenue para la línea
                )

                Text(
                    text = "o continúa con",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                // 3. Línea derecha
                HorizontalDivider(
                    modifier = Modifier.weight(1f), // Se expande para ocupar el lado derecho
                    thickness = 1.dp,
                    color = Color.Gray.copy(alpha = 0.5f)
                )
            }
            //ICONOS DE REDES SOCIALES
            Row(
                modifier = Modifier
                    .padding(50.dp,0.dp)
                    .fillMaxWidth(), // Crucial: obliga al Row a expandirse de extremo a extremo

                horizontalArrangement = Arrangement.SpaceBetween, // Distribuye el espacio entre elementos
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedIconButton(
                    onClick = { /* Tu acción aquí */ },
                    modifier = Modifier
                        .size(80.dp) // Define el tamaño total del botón redondo
                        .padding(4.dp),
                    shape = CircleShape, // Fuerza a que el botón sea completamente redondo
                    border = BorderStroke(1.dp, Color.LightGray) // Define la línea gris del borde
                ) {
                    Image(
                        painter = painterResource(R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier.size(34.dp) // Tamaño del icono dentro del botón
                    )
                }
                OutlinedIconButton(
                    onClick = { /* Tu acción aquí */ },
                    modifier = Modifier
                        .size(80.dp) // Define el tamaño total del botón redondo
                        .padding(4.dp),
                    shape = CircleShape, // Fuerza a que el botón sea completamente redondo
                    border = BorderStroke(1.dp, Color.LightGray) // Define la línea gris del borde
                ) {
                    Image(
                        painter = painterResource(R.drawable.apple),
                        contentDescription = "Apple",
                        modifier = Modifier.size(34.dp) // Tamaño del icono dentro del botón
                    )
                }
                OutlinedIconButton(
                    onClick = { /* Tu acción aquí */ },
                    modifier = Modifier
                        .size(80.dp)
                        .padding(4.dp),
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(R.drawable.facebook),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(34.dp)
                    )
                }
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
                Text("Don't have a account?",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall,)

                Spacer(modifier = Modifier.width(10.dp))

                Text("Sign up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        onSignUp()
                    })
            }
        }
    }
}