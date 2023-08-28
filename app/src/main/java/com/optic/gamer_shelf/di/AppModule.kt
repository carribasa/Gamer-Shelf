package com.optic.gamer_shelf.di

import com.google.firebase.auth.FirebaseAuth
import com.optic.gamer_shelf.data.repository.AuthRepositoryImpl
import com.optic.gamer_shelf.domain.repository.AuthRepository
import com.optic.gamer_shelf.domain.use_cases.auth.AuthUseCases
import com.optic.gamer_shelf.domain.use_cases.auth.GetCurrentUser
import com.optic.gamer_shelf.domain.use_cases.auth.Login
import com.optic.gamer_shelf.domain.use_cases.auth.Logout
import com.optic.gamer_shelf.domain.use_cases.auth.Signup
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

}