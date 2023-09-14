package com.optic.gamer_shelf.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.optic.gamer_shelf.core.Constants.POSTS
import com.optic.gamer_shelf.core.Constants.USERS
import com.optic.gamer_shelf.data.repository.AuthRepositoryImpl
import com.optic.gamer_shelf.data.repository.PostsRepositoryImpl
import com.optic.gamer_shelf.data.repository.UsersRepositoryImpl
import com.optic.gamer_shelf.domain.repository.AuthRepository
import com.optic.gamer_shelf.domain.repository.PostsRepository
import com.optic.gamer_shelf.domain.repository.UsersRepository
import com.optic.gamer_shelf.domain.use_cases.auth.AuthUseCases
import com.optic.gamer_shelf.domain.use_cases.auth.GetCurrentUser
import com.optic.gamer_shelf.domain.use_cases.auth.Login
import com.optic.gamer_shelf.domain.use_cases.auth.Logout
import com.optic.gamer_shelf.domain.use_cases.auth.Signup
import com.optic.gamer_shelf.domain.use_cases.posts.CreatePost
import com.optic.gamer_shelf.domain.use_cases.posts.DeleteLikePost
import com.optic.gamer_shelf.domain.use_cases.posts.DeletePost
import com.optic.gamer_shelf.domain.use_cases.posts.GetPosts
import com.optic.gamer_shelf.domain.use_cases.posts.GetPostsByIdUser
import com.optic.gamer_shelf.domain.use_cases.posts.LikePost
import com.optic.gamer_shelf.domain.use_cases.posts.PostsUseCases
import com.optic.gamer_shelf.domain.use_cases.posts.UpdatePost
import com.optic.gamer_shelf.domain.use_cases.users.Create
import com.optic.gamer_shelf.domain.use_cases.users.GetUserById
import com.optic.gamer_shelf.domain.use_cases.users.SaveImage
import com.optic.gamer_shelf.domain.use_cases.users.Update
import com.optic.gamer_shelf.domain.use_cases.users.UsersUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Named(USERS)
    fun provideStorageUsersRef(storage: FirebaseStorage): StorageReference = storage.reference.child(USERS)

    @Provides
    @Named(USERS)
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    @Named(POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference = storage.reference.child(POSTS)

    @Provides
    @Named(POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POSTS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl

    @Provides
    fun providePostsRepository(impl: PostsRepositoryImpl): PostsRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UsersRepository) = UsersUseCases(
        create = Create(repository),
        getUserById = GetUserById(repository),
        update = Update(repository),
        saveImage = SaveImage(repository)
    )

    @Provides
    fun providePostsUseCases(repository: PostsRepository) = PostsUseCases(
        create = CreatePost(repository),
        getPosts = GetPosts(repository),
        getPostsByIdUser = GetPostsByIdUser(repository),
        deletePost = DeletePost(repository),
        updatePost = UpdatePost(repository),
        likePost = LikePost(repository),
        deleteLikePost = DeleteLikePost(repository)
    )

}