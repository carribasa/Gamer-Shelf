package com.optic.gamer_shelf.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.optic.gamer_shelf.presentation.screens.login.LoginScreen
import com.optic.gamer_shelf.presentation.screens.profile.ProfileScreen
import com.optic.gamer_shelf.presentation.screens.profile_edit.ProfileEditScreen
import com.optic.gamer_shelf.presentation.screens.signup.SignupScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreen.SignUp.route) {
            SignupScreen(navController)
        }
        composable(route = AppScreen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(
            route = AppScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navController, user = it)
            }
        }
    }
}