package com.optic.gamer_shelf.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.optic.gamer_shelf.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>

}