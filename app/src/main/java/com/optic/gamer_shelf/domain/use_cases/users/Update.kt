package com.optic.gamer_shelf.domain.use_cases.users

import com.optic.gamer_shelf.domain.model.User
import com.optic.gamer_shelf.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository){

    suspend operator fun invoke(user: User) = repository.update(user)

}