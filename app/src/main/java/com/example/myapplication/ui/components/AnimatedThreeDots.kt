package com.example.myapplication.ui.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedThreeDots() {
    val infiniteTransition = rememberInfiniteTransition(label = "dots_transition")

    // Creamos la animación de opacidad para 3 puntos con un retraso escalonado
    val alphas = (0..2).map { index ->
        infiniteTransition.animateFloat(
            initialValue = 0.2f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 600,
                    easing = LinearOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse,
                // Aquí está el truco: cada punto empieza su animación 200ms después del anterior
                initialStartOffset = StartOffset(offsetMillis = index * 200)
            ),
            label = "dot_alpha_$index"
        )
    }

    // Renderizamos los puntos en una fila
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        alphas.forEach { alpha ->
            Box(
                modifier = Modifier
                    .size(16.dp)
                    // Color de acento con opacidad dinámica vinculada a la animación
                    .background(
                        color = Color(0xFF0B766B).copy(alpha = alpha.value),
                        shape = CircleShape
                    )
            )
        }
    }
}