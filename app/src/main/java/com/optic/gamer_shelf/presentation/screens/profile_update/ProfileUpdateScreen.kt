package com.optic.gamer_shelf.presentation.screens.profile_update

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.gamer_shelf.presentation.components.DefaultTopBar
import com.optic.gamer_shelf.presentation.screens.profile_update.components.ProfileUpdate
import com.optic.gamer_shelf.presentation.screens.profile_update.components.ProfileUpdateContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    user: String
) {
    Log.d("ProfileEditScreen", "Usuario:$user")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            ProfileUpdateContent(navController)
        },
        bottomBar = {}
    )
    ProfileUpdate()
}