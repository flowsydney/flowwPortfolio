package com.perso.flowwportfoliohilt.news

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val NEWS_ROUTE = "news"
fun NavGraphBuilder.newsScreen() {
    composable(NEWS_ROUTE) {
        val viewModel: NewsViewModel = hiltViewModel()
        NewsScreen(viewModel)
    }
}

fun NavController.navigateToNews(navOptions: NavOptions? = null) {
    this.navigate(NEWS_ROUTE)
}

