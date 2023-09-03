package com.optic.gamer_shelf.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.optic.gamer_shelf.presentation.screens.profile_update.ProfileEditScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileEdit.route
    ) {
        composable(
            route = DetailsScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navController, user = it)
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {

    object ProfileEdit : DetailsScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }

}