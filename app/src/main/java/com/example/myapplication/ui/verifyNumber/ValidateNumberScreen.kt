package com.example.myapplication.ui.verifyNumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.components.AnimatedThreeDots
import kotlinx.coroutines.delay

@Composable
fun ValidateNumberScreen(
    navController:NavController,
) {
    // 1. Temporizador y Navegación Automática
    LaunchedEffect(Unit) {
        delay(3000L) // Tiempo de espera (3 segundos)
        navController.navigate("successValidateNumber")
    }
    Column(
        modifier = Modifier
            .systemBarsPadding() // <-- Empuja el contenido hacia adentro respetando el status bar y navigation bar
            .padding(20.dp,50.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), //equivalente al * en MAUI
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(R.drawable.code_verification),
                    contentDescription = "Logo imagen",
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp),

                    contentScale = ContentScale.Crop,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text="Verifying Coding...",style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text="please wait a moment",color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedThreeDots()
            }
        }

        //PIE DE PAGINA
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text="Your data is 100% secure",color = Color.Gray)
        }
    }
}