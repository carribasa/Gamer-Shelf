package com.optic.gamer_shelf.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.optic.gamer_shelf.presentation.ui.theme.Red200

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    color: Color = Red200,
    icon: ImageVector = Icons.Default.ArrowForward
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 35.dp),
        colors = ButtonDefaults.buttonColors(color),
        onClick = { onClick }) {
        Icon(
            imageVector = icon,
            contentDescription = "Icono flecha boton"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}