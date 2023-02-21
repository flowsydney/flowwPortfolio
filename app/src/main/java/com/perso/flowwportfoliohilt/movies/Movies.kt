package com.perso.flowwportfoliohilt.movies

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val MOVIES_ROUTE = "movies"
fun NavGraphBuilder.moviesScreen() {
    composable(MOVIES_ROUTE) {
        val viewModel: MoviesViewModel = hiltViewModel()
        MoviesScreen()
    }
}

fun NavController.navigateToMovies(navOptions: NavOptions? = null) {
    this.navigate(MOVIES_ROUTE)
}

@Composable
fun MoviesScreen() {
    Box {
        Text(text = "Movies")
    }
}