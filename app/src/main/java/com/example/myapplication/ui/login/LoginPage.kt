package com.example.myapplication.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.ui.components.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@Composable
fun LoginPage(
    navController:NavController,
    // Inyectamos el ViewModel de forma automática
    viewModel: LoginViewModel = viewModel()
) {
    var email by remember { mutableStateOf("") }
    val formaRedondeada = RoundedCornerShape(16.dp)
    // "Colectamos" el estado del ViewModel y lo convertimos en un State de Compose
    val state by viewModel.uiState.collectAsState()

    // Efecto lanzado cuando el estado de navegación cambia a true
    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect{ ruta ->
            navController.navigate("home")
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .shadow(elevation = 8.dp, shape = formaRedondeada)
            .background(Color.White, shape = formaRedondeada)
            .border(width = 2.dp, color = Color(0xFF0B766B), shape = formaRedondeada)
            .clip(formaRedondeada),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // El TextField ahora lee del estado del ViewModel
        CustomTextField(
            value = state.textoIngresado,
            onValueChange = { nuevoTexto ->
                viewModel.onTextoCambiado(nuevoTexto)
            },
            label = "Nombre completo",
            placeholder = "Ej. Juan Pérez",
            isError = state.mostrarError != null,
            errorMessage = state.mostrarError
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextFieldClasic(
            value = email,
            onValueChange = {
                email = it
            },
            label = "Correo electrónico",
            placeholder = "Ej. Juan Pérez",
        )

        Spacer(modifier = Modifier.height(16.dp))

        // El botón solo invoca la función de validación del ViewModel
        Button(onClick = { viewModel.onLoginClick() }) {
            Text("Verificar y Continuar")
        }
    }
}