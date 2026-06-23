package com.example.myapplication.ui.components
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

enum class LoginType { EMAIL, PHONE }

@Composable
fun CustomLoginSwitch(
    selectedOption: LoginType,
    onOptionSelected: (LoginType) -> Unit,
    modifier: Modifier = Modifier
) {
    // Contenedor principal (forma de píldora/óvalo)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(CircleShape)
            .background(Color.LightGray.copy(alpha = 0.5f))
            .padding(4.dp), // Padding interno para que los botones no toquen el borde
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón Email
        SwitchButton(
            text = "Email",
            isSelected = selectedOption == LoginType.EMAIL,
            onClick = { onOptionSelected(LoginType.EMAIL) },
            modifier = Modifier.weight(1f)
        )

        // Botón Teléfono
        SwitchButton(
            text = "Teléfono",
            isSelected = selectedOption == LoginType.PHONE,
            onClick = { onOptionSelected(LoginType.PHONE) },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun SwitchButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Animamos el color de fondo para una transición suave
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
        animationSpec = tween(durationMillis = 300),
        label = "bgColorAnimation"
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimary else Color.Gray,
        label = "textColorAnimation"
    )

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}