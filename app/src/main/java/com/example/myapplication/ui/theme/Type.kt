package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import androidx.compose.ui.text.font.FontStyle

// 1. Definimos la familia de fuentes
val GoogleSansFamily = FontFamily(
    Font(resId = R.font.googlesans_regular, weight = FontWeight.Normal),
    Font(resId = R.font.googlesans_bold, weight = FontWeight.Bold),
    Font(resId = R.font.googlesans_medium, weight = FontWeight.Medium),
    Font(resId = R.font.googlesans_semibold, weight = FontWeight.SemiBold),

    // CORRECCIÓN: Agregar style = FontStyle.Italic a las variantes cursivas
    Font(resId = R.font.googlesans_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.googlesans_mediumitalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resId = R.font.googlesans_semibolditalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(resId = R.font.googlesans_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic)
)

// 2. Configuramos los estilos globales de Material3
val MiTipografia = Typography(
    bodyLarge = TextStyle( //lo usan los inputs y text
        fontFamily = GoogleSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelLarge = TextStyle( //lo usan los botones
        fontFamily = GoogleSansFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = GoogleSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = GoogleSansFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    bodySmall = TextStyle( //lo usa el label del input
        fontFamily = GoogleSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)