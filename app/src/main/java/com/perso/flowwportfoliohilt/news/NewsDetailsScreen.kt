package com.perso.flowwportfoliohilt.news

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.perso.flowwportfoliohilt.home.HOME_ROUTE
import com.perso.flowwportfoliohilt.home.HomeScreen
import com.perso.flowwportfoliohilt.home.HomeViewModel

const val NEWS_DETAILS = "news_details"

fun NavGraphBuilder.newsDetailsScreen() {
    composable(route = NEWS_DETAILS) {
        NewsDetailsScreen()
    }
}

fun NavController.navigateToNewsDetails(navOptions: NavOptions? = null) {
    this.navigate(NEWS_DETAILS)
}
@Composable
internal fun NewsDetailsScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = "This screen is working, add article detail here")
    }
}