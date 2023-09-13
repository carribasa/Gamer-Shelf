package com.optic.gamer_shelf.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.presentation.components.ProgressBar
import com.optic.gamer_shelf.presentation.screens.posts.PostsViewModel

@Composable
fun GetPosts(viewModel: PostsViewModel = hiltViewModel()) {
    when (val response = viewModel.postsResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            PostsContent(posts = response.data)
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?: "Error desconido",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}