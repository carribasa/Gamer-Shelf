package com.optic.gamer_shelf.domain.use_cases.users

import com.optic.gamer_shelf.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository) {

    operator fun invoke(id: String) = repository.getUserById(id)

}