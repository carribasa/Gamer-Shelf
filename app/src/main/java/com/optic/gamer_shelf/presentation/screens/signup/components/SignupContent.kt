package com.optic.gamer_shelf.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.optic.gamer_shelf.R
import com.optic.gamer_shelf.presentation.components.DefaultButton
import com.optic.gamer_shelf.presentation.components.DefaultTextField
import com.optic.gamermvvmapp.presentation.ui.theme.Darkgray500
import com.optic.gamermvvmapp.presentation.ui.theme.GamerShelfTheme
import com.optic.gamermvvmapp.presentation.ui.theme.Red200

@Composable
fun SignupContent() {
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
            .height(230.dp)
            .background(Red200)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                modifier = Modifier.height(120.dp),
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Imagen User"
            )
        }
    }
}

@Composable
fun CardForm() {
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier
            .padding(
                start = 40.dp,
                end = 40.dp,
                top = 170.dp
            ),
        backgroundColor = Darkgray500
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
                text = "REGISTRO",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Por favor, ingresa estos datos para continuar",
                fontSize = 12.sp,
                color = Color.Gray
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 10.dp),
                value = username,
                onValueChange = { username = it },
                label = "Nombre de usuario",
                icon = Icons.Default.Person,
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = email,
                onValueChange = { email = it },
                label = "Email",
                icon = Icons.Default.Email,
                hideText = true,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = password,
                onValueChange = { password = it },
                label = "Contraseña",
                icon = Icons.Default.Lock,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirmar contraseña",
                icon = Icons.Outlined.Lock,
                hideText = true
            )
            DefaultButton(
                text = "REGISTRARSE",
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginContent() {
    GamerShelfTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            SignupContent()
        }
    }
}
