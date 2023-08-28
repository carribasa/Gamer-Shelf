package com.optic.gamer_shelf.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.gamer_shelf.presentation.screens.profile.components.ProfileContent
import com.optic.gamermvvmapp.presentation.ui.theme.GamerShelfTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {},
        content = {
            ProfileContent(navController)
        },
        bottomBar = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreview() {
    GamerShelfTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileScreen(rememberNavController())
        }
    }
}
