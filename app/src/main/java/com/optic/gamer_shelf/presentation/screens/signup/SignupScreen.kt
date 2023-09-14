package com.optic.gamer_shelf.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.gamer_shelf.presentation.components.DefaultTopBar
import com.optic.gamer_shelf.presentation.screens.signup.components.SignUp
import com.optic.gamer_shelf.presentation.screens.signup.components.SignupContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignupScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            SignupContent(navController)
        },
        bottomBar = {}
    )
    SignUp(navController = navController)

}