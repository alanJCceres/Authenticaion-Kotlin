package com.example.myapplication.ui.login
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.components.CustomLoginSwitch
import com.example.myapplication.ui.components.LoginType

@Composable
fun MainLoginScreen(
    navController:NavController,
) {
    // Estado que guarda la opción seleccionada. Por defecto, EMAIL.
    var currentLoginType by remember { mutableStateOf(LoginType.EMAIL) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(26.dp))
        //TITULO
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome Back",
                style = MaterialTheme.typography.titleLarge)
            Text("Sign to your Sudapass account",
                color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(26.dp))
        // 2. Nuestro Switch Personalizado
        CustomLoginSwitch(
            selectedOption = currentLoginType,
            onOptionSelected = { nuevaOpcion ->
                currentLoginType = nuevaOpcion
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 3. El contenido dinámico basado en el Switch
        // Crossfade anima la transición entre las dos vistas
        Crossfade(targetState = currentLoginType, label = "loginTransition") { type ->
            when (type) {
                LoginType.EMAIL -> {
                    // El viewModel se asocia al ciclo de vida de la Actividad/Fragmento
                    LoginPage(onLoginSuccess = {
                        // Aquí se decide a dónde redirigir desde el padre
                        navController.navigate("home")
                    })
                }
                LoginType.PHONE -> {
                    LoginPhoneScreen(onLoginSuccess = {
                        // Aquí se decide a dónde redirigir desde el padre
                        navController.navigate("verifyNumber")
                    })
                }
            }
        }
    }
}