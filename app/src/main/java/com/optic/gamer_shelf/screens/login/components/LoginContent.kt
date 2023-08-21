package com.optic.gamer_shelf.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.optic.gamer_shelf.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(130.dp),
            painter = painterResource(id = R.drawable.control),
            contentDescription = "Imagen Controlador XboX"
        )
        Text(
            text = "FIREBASE MVVM"
        )
        Text(
            modifier = Modifier.padding(top = 30.dp, bottom = 0.dp, start = 0.dp, end = 0.dp),
            text = "LOGIN"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Inicia sesión para continuar"
        )
        TextField(
            modifier = Modifier.padding(top = 25.dp),
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Correo electrónico")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = { },
            placeholder = {
                Text(text = "Contraseña")
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 15.dp),
            onClick = { }) {
            Text(text = "INICIAR SESIÓN")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginContent() {
    LoginContent()
}
