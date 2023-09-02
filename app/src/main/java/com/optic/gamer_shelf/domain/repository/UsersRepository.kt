package com.optic.gamer_shelf.domain.repository

import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UsersRepository {

    suspend fun create(user: User): Response<Boolean>
    suspend fun update(user: User): Response<Boolean>
    suspend fun saveImage(file: File): Response<String>
    fun getUserById(id: String): Flow<User>

}