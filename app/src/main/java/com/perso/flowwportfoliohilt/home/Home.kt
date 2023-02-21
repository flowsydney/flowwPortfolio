package com.perso.flowwportfoliohilt.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HOME_ROUTE = "home"
fun NavGraphBuilder.homeScreen() {
    composable(HOME_ROUTE) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen()
    }
}

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(HOME_ROUTE)
}

@Composable
fun HomeScreen() {
    Box {
        Text(text = "Home")
    }
}