package com.example.myapplication.ui.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.components.SocialAuthButton
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme

@Composable
fun InicioPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.logo_login),
                contentDescription = "Logo imagen",
                modifier = Modifier
                    .height(550.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {navController.navigate("login")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = MaterialTheme.colorScheme.primary,
//                    contentColor = Color.White
//                )
            ) { Text("Sign in") }
            Spacer(modifier = Modifier.height(10.dp))

            SocialAuthButton("Continue with Google",
                R.drawable.google,
                {})

            Spacer(modifier = Modifier.height(10.dp))

            SocialAuthButton("Continue with Apple",
                R.drawable.apple,
                {})

            Spacer(modifier = Modifier.height(10.dp))

            SocialAuthButton("Continue with Facebook",
                R.drawable.facebook,
                {})
        }
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
                    // Tu código para ir a la otra pantalla aquí
                    navController.navigate("login")
                })
        }

    }
}