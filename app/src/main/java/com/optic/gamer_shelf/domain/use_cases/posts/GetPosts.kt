package com.optic.gamer_shelf.domain.use_cases.posts

import com.optic.gamer_shelf.domain.repository.PostsRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostsRepository){

    operator fun invoke() = repository.getPosts()


}
