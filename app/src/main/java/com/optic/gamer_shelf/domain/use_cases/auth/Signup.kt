package com.optic.gamer_shelf.domain.use_cases.auth

import com.optic.gamer_shelf.domain.model.User
import com.optic.gamer_shelf.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}