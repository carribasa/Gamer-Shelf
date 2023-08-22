package com.optic.gamer_shelf.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import com.optic.gamer_shelf.ui.theme.Darkgray500
import com.optic.gamer_shelf.ui.theme.GamerShelfTheme
import com.optic.gamer_shelf.ui.theme.Red200
import com.optic.gamer_shelf.ui.theme.Red500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        BoxHeader()
        CardForm()
    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .background(Red200)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
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
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardForm() {
    Card(
        modifier = Modifier
            .padding(
                start = 40.dp,
                end = 40.dp,
                top = 200.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = Darkgray500,
        )
    ) {
        Column(
            Modifier.padding(horizontal = 20.dp)
        ) {
            Text(
                modifier = Modifier.padding(
                    top = 40.dp,
                    bottom = 0.dp,
                    start = 0.dp,
                    end = 0.dp
                ),
                text = "LOGIN",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Por favor, inicia sesión para continuar",
                fontSize = 12.sp,
                color = Color.Gray
            )
            OutlinedTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = "",
                onValueChange = { },
                label = {
                    Text(text = "Correo electrónico")
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Icono email login",
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = {
                    Text(text = "Contraseña")
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Icono contraseña login"
                    )
                }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 35.dp),
                colors = ButtonDefaults.buttonColors(Red200),
                onClick = { }) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Icono flecha boton login"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "INICIAR SESION")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginContent() {
    GamerShelfTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            LoginContent()
        }
    }
}
