package com.optic.gamer_shelf.domain.use_cases.auth

data class AuthUseCases (
    val getCurrentUser: GetCurrentUser,
    val login: Login
)