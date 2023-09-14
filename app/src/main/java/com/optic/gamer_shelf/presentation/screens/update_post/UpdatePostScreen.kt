package com.optic.gamer_shelf.presentation.screens.update_post

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.gamer_shelf.presentation.components.DefaultButton
import com.optic.gamer_shelf.presentation.components.DefaultTopBar
import com.optic.gamer_shelf.presentation.screens.update_post.components.UpdatePost
import com.optic.gamer_shelf.presentation.screens.update_post.components.UpdatePostContent

@Composable
fun UpdatePostScreen(navController: NavHostController, post: String, viewModel: UpdatePostViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            UpdatePostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "ACTUALIZAR",
                onClick = { viewModel.onUpdatePost() }
            )
        }
    )
    UpdatePost()

}