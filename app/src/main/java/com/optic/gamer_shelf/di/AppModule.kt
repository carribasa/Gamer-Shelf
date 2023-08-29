package com.optic.gamer_shelf.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.optic.gamer_shelf.core.Constants.USERS
import com.optic.gamer_shelf.data.repository.AuthRepositoryImpl
import com.optic.gamer_shelf.data.repository.UsersRepositoryImpl
import com.optic.gamer_shelf.domain.repository.AuthRepository
import com.optic.gamer_shelf.domain.repository.UsersRepository
import com.optic.gamer_shelf.domain.use_cases.auth.AuthUseCases
import com.optic.gamer_shelf.domain.use_cases.auth.GetCurrentUser
import com.optic.gamer_shelf.domain.use_cases.auth.Login
import com.optic.gamer_shelf.domain.use_cases.auth.Logout
import com.optic.gamer_shelf.domain.use_cases.auth.Signup
import com.optic.gamer_shelf.domain.use_cases.users.Create
import com.optic.gamer_shelf.domain.use_cases.users.UsersUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUserUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository)
    )

}