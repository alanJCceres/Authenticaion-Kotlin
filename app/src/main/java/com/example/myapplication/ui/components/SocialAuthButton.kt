package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SocialAuthButton(
    text: String,
    iconResId: Int,
    onClick: ()->Unit
) {
    OutlinedButton(
        onClick = onClick ,
        modifier = Modifier.fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0xFF1F1F1F)
        ),
    ) {

        Image(
            painter = painterResource(id = iconResId),
            contentDescription = "Logo",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Text(text = text)
    }
}