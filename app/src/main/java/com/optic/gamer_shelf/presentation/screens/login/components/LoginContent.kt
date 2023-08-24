package com.optic.gamer_shelf.presentation.screens.login.components

import android.util.Log
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.gamer_shelf.R
import com.optic.gamer_shelf.presentation.components.DefaultButton
import com.optic.gamer_shelf.presentation.components.DefaultTextField
import com.optic.gamer_shelf.presentation.screens.login.LoginViewModel
import com.optic.gamermvvmapp.presentation.ui.theme.Darkgray500
import com.optic.gamermvvmapp.presentation.ui.theme.GamerShelfTheme
import com.optic.gamermvvmapp.presentation.ui.theme.Red200

@Composable
fun LoginContent(viewModel: LoginViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
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
        Card(
            modifier = Modifier
                .padding(
                    start = 40.dp,
                    end = 40.dp,
                    top = 200.dp
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
                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it },
                    label = "Email",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrMsg.value,
                    validateField = {
                        viewModel.validateEmail()
                    }
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 5.dp),
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    label = "Contraseña",
                    icon = Icons.Default.Lock,
                    hideText = true,
                    errorMsg = viewModel.passwordErrMsg.value,
                    validateField = {
                        viewModel.validatePassword()
                    }
                )
                DefaultButton(
                    text = "INICIAR SESION",
                    onClick = {
                        Log.d("LoginContent", "Email: ${viewModel.email.value}")
                        Log.d("LoginContent", "Password: ${viewModel.password.value}")
                    },
                    enabled = viewModel.isEnabledLoginButton
                )
            }
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
            LoginContent()
        }
    }
}
