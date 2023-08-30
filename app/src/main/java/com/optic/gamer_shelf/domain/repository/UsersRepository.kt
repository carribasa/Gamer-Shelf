package com.optic.gamer_shelf.domain.repository

import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun create(user: User) : Response<Boolean>
    fun getUserById(id: String): Flow<User>

}