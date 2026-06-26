package com.example.myapplication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginPhoneViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    // El estado público (de solo lectura) que la interfaz va a observar
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    //Maneja el estado de la navegacion
   private val _navigationEvent = Channel<String>()
    val navigationEvent = _navigationEvent.receiveAsFlow()
    fun onTextoCambiado(nuevoTexto: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(
                textoIngresado = nuevoTexto,
                mostrarError = null // Limpiamos el error si vuelve a escribir
            )
        }
    }
//    fun onLoginClick() {
//        viewModelScope.launch {
//            // ...haces la petición a la API...
//            _navigationEvent.send("verifyNumber")
//        }
//    }
}