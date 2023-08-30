package com.optic.gamer_shelf.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.presentation.components.ProgressBar
import com.optic.gamer_shelf.presentation.navigation.AppScreen
import com.optic.gamer_shelf.presentation.screens.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    when (val loginResponse = viewModel.loginResponse) {
        // Mostrar que se esta realizando la peticion y todavia esta en proceso
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AppScreen.Profile.route) {
                    // Eliminar historial de pantallas tras logout
                    popUpTo(AppScreen.Login.route) { inclusive = true }
                }
            }
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                loginResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}