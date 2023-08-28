package com.optic.gamer_shelf.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.optic.gamermvvmapp.presentation.ui.theme.Red200

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit,
    color: Color = Red200,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled: Boolean = true
) {
    Column {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 35.dp),
            colors = ButtonDefaults.buttonColors(color),
            enabled = enabled,
            onClick = { onClick() }) {
            Icon(
                imageVector = icon,
                contentDescription = "Icono flecha boton"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text)
        }
    }

}