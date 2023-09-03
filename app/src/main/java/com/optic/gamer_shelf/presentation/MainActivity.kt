package com.optic.gamer_shelf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.optic.gamer_shelf.presentation.navigation.RootNavGraph
import com.optic.gamermvvmapp.presentation.ui.theme.GamerShelfTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerShelfTheme(darkTheme = true) {
                Surface(
                ) {
                    navController = rememberNavController()
                    RootNavGraph(navController = navController)
                }
            }
        }
    }
}