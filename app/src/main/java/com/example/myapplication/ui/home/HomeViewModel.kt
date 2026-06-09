package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.text.filter


data class HomeIu(
    val num1: Int = 0,
    val num2: Int = 0,
    val num3: Int = 0,
    val mensajeMayor:String? = "",
    val mensajeMenor:String? = ""
)

class HomeViewModel: ViewModel(){
    private val _iuState = MutableStateFlow(HomeIu())
    val iuState: StateFlow<HomeIu> = _iuState.asStateFlow()

    fun onNum1Change(nuevoNum:String){
        val convertNum = nuevoNum.filter { it.isDigit() }
        val numeroEntero = convertNum.toIntOrNull() ?: 0
        _iuState.value = _iuState.value.copy(num1 = numeroEntero)
    }
    fun onNum2Change(nuevoNum:String){
        val convertNum = nuevoNum.filter { it.isDigit() }
        val numeroEntero = convertNum.toIntOrNull() ?: 0
        _iuState.value = _iuState.value.copy(num2 = numeroEntero)
    }
    fun onNum3Change(nuevoNum:String){
        val convertNum = nuevoNum.filter { it.isDigit() }
        val numeroEntero = convertNum.toIntOrNull() ?: 0
        _iuState.value = _iuState.value.copy(num3 = numeroEntero)
    }
    fun onCalcular(){
        val num1:Int = _iuState.value.num1
        val num2:Int = _iuState.value.num2
        val num3:Int = _iuState.value.num3
        val numMayor: Int = maxOf(num1, num2, num3)
        _iuState.update {it.copy(mensajeMayor="El numero mayor es: $numMayor")}
    }
}