package com.perso.flowwportfoliohilt.news

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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

@Composable
fun NewsScreen(viewModel: NewsViewModel) {
    val data = viewModel.res.observeAsState()
    Box {
        val firstText = data.value?.data?.articles?.get(0)?.title ?: "No Data"
        Text(text = firstText)
    }
}