package com.perso.flowwportfoliohilt.news

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val NEWS_ROUTE = "news"
private const val newsGraphRoutePattern = "news_graph"

fun NavGraphBuilder.newsGraph(
    navigateToDetailsNews: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit) {
    navigation(route = newsGraphRoutePattern, startDestination = NEWS_ROUTE) {
        composable(NEWS_ROUTE) {
            val viewModel: NewsViewModel = hiltViewModel()
            NewsScreen(viewModel, navigateToDetailsNews)
        }
        nestedGraphs()
    }
}

fun NavController.navigateToNews(navOptions: NavOptions? = null) {
    this.navigate(NEWS_ROUTE)
}

