package com.optic.gamer_shelf.domain.repository

import com.optic.gamer_shelf.domain.model.Post
import com.optic.gamer_shelf.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostsRepository {

    fun getPosts(): Flow<Response<List<Post>>>
    suspend fun create(post: Post, file: File): Response<Boolean>


}