package com.perso.flowwportfoliohilt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.perso.flowwportfoliohilt.home.HOME_ROUTE
import com.perso.flowwportfoliohilt.home.homeScreen
import com.perso.flowwportfoliohilt.movies.moviesScreen
import com.perso.flowwportfoliohilt.news.navigateToNewsDetails
import com.perso.flowwportfoliohilt.news.newsDetailsScreen
import com.perso.flowwportfoliohilt.news.newsGraph
import com.perso.flowwportfoliohilt.settings.settingsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE
    ) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen()
        moviesScreen()
        newsGraph(
            navigateToDetailsNews = {
                navController.navigateToNewsDetails()
            },
            nestedGraphs = {
                newsDetailsScreen()
            }
        )
        settingsScreen()
    }
}