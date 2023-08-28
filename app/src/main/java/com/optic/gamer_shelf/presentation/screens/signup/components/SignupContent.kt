package com.optic.gamer_shelf.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.gamer_shelf.R
import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.presentation.components.DefaultButton
import com.optic.gamer_shelf.presentation.components.DefaultTextField
import com.optic.gamer_shelf.presentation.navigation.AppScreen
import com.optic.gamer_shelf.presentation.screens.signup.SignupViewModel
import com.optic.gamermvvmapp.presentation.ui.theme.Darkgray500
import com.optic.gamermvvmapp.presentation.ui.theme.Red200

@Composable
fun SignupContent(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {

    val signupFlow = viewModel.signupFlow.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
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
                // Campo username
                DefaultTextField(
                    modifier = Modifier.padding(top = 10.dp),
                    value = viewModel.username.value,
                    onValueChange = { viewModel.username.value = it },
                    label = "Nombre de usuario",
                    icon = Icons.Default.Person,
                )
                // Campo email
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
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
                // Campo contraseña
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    label = "Contraseña",
                    icon = Icons.Default.Lock,
                    hideText = true,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.passwordErrMsg.value,
                    validateField = {
                        viewModel.validatePasswordLength()
                    }
                )
                // Campo confirmar contraseña
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.confirmPassword.value,
                    onValueChange = { viewModel.confirmPassword.value = it },
                    label = "Confirmar contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    errorMsg = viewModel.confirmPasswordErrMsg.value,
                    validateField = {
                        viewModel.validateSamePassword()
                    }
                )
                // Boton Registrarse
                DefaultButton(
                    modifier = Modifier,
                    text = "REGISTRARSE",
                    onClick = { viewModel.onSignup() },
                    enabled = viewModel.isEnabledSignupButton
                )
            }
        }
    }

    signupFlow.value.let {
        when (it) {
            Response.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }

            is Response.Success -> {
                LaunchedEffect(Unit) {
                    navController.popBackStack(AppScreen.Login.route, true)
                    navController.navigate(route = AppScreen.Profile.route)
                }
            }
            is Response.Failure -> {
                Toast.makeText(LocalContext.current, it.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
            }

            else -> {}
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewLoginContent() {
//    GamerShelfTheme(darkTheme = true) {
//        Surface(
//            color = MaterialTheme.colors.background
//        ) {
//            SignupContent()
//        }
//    }
//}
