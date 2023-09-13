package com.optic.gamer_shelf.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.gamer_shelf.domain.model.Post
import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.domain.use_cases.posts.PostsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsUseCases: PostsUseCases
) : ViewModel() {
    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)

    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postsUseCases.getPosts().collect() { response ->
            postsResponse = response

        }
    }
}