package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Home(viewModel: HomeViewModel = viewModel()){
    val state by viewModel.iuState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text= "Encontrar el mayor y menor", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value=state.num1.toString(),
            onValueChange = {nuevoValor ->
                viewModel.onNum1Change(nuevoValor)
            },
            label={ Text("Número 1") },
            keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value=state.num2.toString(),
            onValueChange = {nuevoValor ->
                viewModel.onNum2Change(nuevoValor)
            },
            label={ Text("Número 2") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value=state.num3.toString(),
            onValueChange = {nuevoValor ->
                viewModel.onNum3Change(nuevoValor)
            },
            label={ Text("Número 3") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ))


        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {viewModel.onCalcular()}) { Text(text="Calcular")}
        Spacer(modifier = Modifier.height(20.dp))

        state.mensajeMayor?.let {resultadoMayor->
            Text(
                text=resultadoMayor, fontSize = 20.sp)
        }

    }
}