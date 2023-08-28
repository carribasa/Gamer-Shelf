package com.optic.gamer_shelf.presentation.components

import androidx.compose.foundation.layout.Spacer
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
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Red200,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled: Boolean = true
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        enabled = enabled
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Icono flecha boton"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }

}