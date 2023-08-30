package com.optic.gamer_shelf.presentation.screens.profile_edit

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.optic.gamer_shelf.presentation.components.DefaultTopBar
import com.optic.gamer_shelf.presentation.screens.profile_edit.components.ProfileEditContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            ProfileEditContent(navController)
        },
        bottomBar = {}
    )
}