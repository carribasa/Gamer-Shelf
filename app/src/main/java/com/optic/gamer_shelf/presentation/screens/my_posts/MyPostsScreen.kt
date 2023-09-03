package com.optic.gamer_shelf.presentation.screens.my_posts

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MyPostScreen(navController: NavHostController) {

    Scaffold(content = {
        Text(text = "MyPostsScreen")
    }) 

}