package com.example.myapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation

data class Country(
    val name: String,
    val code: String,
    val flag: String
)
// Lista de ejemplo
val defaultCountries = listOf(
    Country("Bolivia", "+591", "🇧🇴"),
    Country("Estados Unidos", "+1", "🇺🇸"),
    Country("España", "+34", "🇪🇸"),
    Country("México", "+52", "🇲🇽"),
    Country("Colombia", "+57", "🇨🇴"),
    Country("Argentina", "+54", "🇦🇷")
)
@Composable
fun PhoneNumberInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String = "",
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
    errorMessage: String? = null,
    countries: List<Country> = defaultCountries)
{
    // Estados del componente
    //var phoneNumber by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf(countries.first()) }
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            color = if (isError) Color.Red else Color.DarkGray,
            modifier = Modifier.padding(bottom = 6.dp) // Espacio entre el título y la caja
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder) },
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                // Colores en estado normal
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.LightGray.copy(alpha = 0.6f),
                focusedLabelColor = Color(0xFF0B766B),
                unfocusedLabelColor = Color.Gray,
                unfocusedContainerColor = Color.White, //Fondo blanco sin foco
                focusedContainerColor = Color.White, //fondo blanco cuando se haga foco
                errorContainerColor = Color.White, //fondo blanco cuando ocurra un error
                // Colores en estado de error
                errorBorderColor = Color.Red,
                errorLabelColor = Color.Red,
                //errorContainerColor = Color(0xFFFFF5F5)
            ),
            leadingIcon = {
                // Contenedor para el selector de país
                Box {
                    Row(
                        modifier = Modifier
                            .clickable { expanded = true }
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(text = selectedCountry.flag, fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = selectedCountry.code)
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Seleccionar país"
                        )
                    }

                    // Menú desplegable
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        countries.forEach { country ->
                            DropdownMenuItem(
                                text = {
                                    Text("${country.flag} ${country.name} (${country.code})")
                                },
                                onClick = {
                                    selectedCountry = country
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        )
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }

}