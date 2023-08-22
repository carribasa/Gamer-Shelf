package com.optic.gamer_shelf.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen() {
    Scaffold(
        topBar = {},
        content = {
            Text(text = "SignupScreen")
        },
        bottomBar = {}
    )
}