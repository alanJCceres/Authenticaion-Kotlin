package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.home.Home
import com.example.myapplication.ui.inicio.InicioPage
import com.example.myapplication.ui.login.LoginPage
import com.example.myapplication.ui.login.MainLoginScreen
import com.example.myapplication.ui.verifyNumber.VerifyNumberScreen

@Composable
fun AppNavigation() {
    // El navController gestiona el historial de pantallas
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio"){
            InicioPage(navController = navController)
        }
        composable("mainlogin") {
            MainLoginScreen(navController = navController)
        }
        composable("home") {
            Home()
        }
        composable("verifyNumber"){
            VerifyNumberScreen()
        }
    }
}