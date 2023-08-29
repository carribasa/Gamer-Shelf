package com.optic.gamer_shelf.domain.repository

import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.domain.model.User

interface UsersRepository {

    suspend fun create(user: User) : Response<Boolean>

}