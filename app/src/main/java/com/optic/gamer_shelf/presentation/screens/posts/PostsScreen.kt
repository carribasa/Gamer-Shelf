package com.optic.gamer_shelf.presentation.screens.posts

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun PostsScreen(navController: NavHostController) {

    Scaffold(content = {
        Text(text = "PostsScreen")
    }) 

}