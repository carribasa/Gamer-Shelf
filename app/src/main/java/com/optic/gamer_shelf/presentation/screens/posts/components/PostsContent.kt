package com.optic.gamer_shelf.presentation.screens.posts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.optic.gamer_shelf.domain.model.Post

@Composable
fun PostsContent(
    posts: List<Post>
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = posts
        ) { post ->
            Text(text = post.name)
        }
    }

}