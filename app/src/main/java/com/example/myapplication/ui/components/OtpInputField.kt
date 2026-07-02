package com.example.myapplication.ui.components
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OtpInputField(
    modifier: Modifier = Modifier,
    otpLength: Int = 4,
    onOtpComplete: (String) -> Unit
) {
    var otpValue by remember { mutableStateOf("") }

    BasicTextField(
        value = otpValue,
        onValueChange = { newValue ->
            // Filtramos para que solo acepte números
            val digitsOnly = newValue.filter { it.isDigit() }

            // Limitamos la longitud máxima
            if (digitsOnly.length <= otpLength) {
                otpValue = digitsOnly

                // Notificamos si se completó el código
                if (digitsOnly.length == otpLength) {
                    onOtpComplete(digitsOnly)
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword // Muestra el teclado numérico
        ),
        modifier = modifier,
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpLength) { index ->
                    val char = when {
                        index >= otpValue.length -> ""
                        else -> otpValue[index].toString()
                    }

                    val isFocused = otpValue.length == index

                    // Diseño individual de cada casilla
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(56.dp)
                            .border(
                                width = if (isFocused) 2.dp else 1.dp,
                                color = if (isFocused) MaterialTheme.colorScheme.primary else Color.Gray,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char,
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}