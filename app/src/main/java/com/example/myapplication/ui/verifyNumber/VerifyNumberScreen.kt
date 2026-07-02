package com.example.myapplication.ui.verifyNumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.OtpInputField

@Composable
fun VerifyNumberScreen() {
    Column(
        modifier = Modifier
            .systemBarsPadding() //hace que se ajuste la pantalla para respetar los iconos del top y del bottom
            .padding(20.dp,20.dp)
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
                    painter = painterResource(R.drawable.phone_password),
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
                Text(text="Verify your number",style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text="We've sent a 6-digit code to",color = Color.Gray)
                Text(text="+591 75971702")
            }
            Spacer(modifier = Modifier.height(26.dp))
            OtpInputField(
                otpLength = 6, // Puedes cambiar la cantidad de dígitos aquí
                onOtpComplete = { codigoFinal ->
                    // Aquí ejecutas la lógica para verificar el código con tu backend
                    println("Código ingresado: $codigoFinal")
                }
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Didn't receive the code ?",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text("Resend code",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    // Tu código para ir a la otra pantalla aquí

                })
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(20.dp),
            onClick = {}
        ) {
            Text("Verify Code")
        }
    }
}