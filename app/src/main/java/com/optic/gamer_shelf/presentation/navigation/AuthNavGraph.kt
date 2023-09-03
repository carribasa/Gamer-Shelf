package com.optic.gamer_shelf.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.optic.gamer_shelf.presentation.screens.login.LoginScreen
import com.optic.gamer_shelf.presentation.screens.signup.SignupScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AuthScreen.SignUp.route) {
            SignupScreen(navController)
        }
    }
}

sealed class AuthScreen(val route: String) {

    object Login : AuthScreen("login")
    object SignUp : AuthScreen("signup")

}
