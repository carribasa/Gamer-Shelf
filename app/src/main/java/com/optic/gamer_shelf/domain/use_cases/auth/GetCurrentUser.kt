package com.optic.gamer_shelf.domain.use_cases.auth

import com.optic.gamer_shelf.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.currentUser

}