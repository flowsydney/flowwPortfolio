package com.perso.flowwportfoliohilt.news

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val NEWS_ROUTE = "news"
fun NavGraphBuilder.newsScreen() {
    composable(NEWS_ROUTE) {
        val viewModel: NewsViewModel = hiltViewModel()
        NewsScreen()
    }
}

fun NavController.navigateToNews(navOptions: NavOptions? = null) {
    this.navigate(NEWS_ROUTE)
}

@Composable
fun NewsScreen() {
    Box {
        Text(text = "News")
    }
}