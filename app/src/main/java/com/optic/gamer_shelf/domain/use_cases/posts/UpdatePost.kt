package com.optic.gamer_shelf.domain.use_cases.posts

import com.optic.gamer_shelf.domain.model.Post
import com.optic.gamer_shelf.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class UpdatePost @Inject constructor(private val repository: PostsRepository){

    suspend operator fun invoke(post: Post, file: File?) = repository.update(post, file)

}