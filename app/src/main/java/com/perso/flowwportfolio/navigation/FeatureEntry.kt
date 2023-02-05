package com.perso.flowwportfolio.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable

interface FeatureEntry {
    val featureRoute: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()
}

interface ComposableFeatureEntry : FeatureEntry {
    fun NavGraphBuilder.composable(
        navController: NavHostController,
        destinations: Destinations) {

        composable(featureRoute) { backStackEntry ->
            Composable(navController, destinations, backStackEntry)
        }
    }

    @Composable
    fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    )
}

interface AggregateFeatureEntry : FeatureEntry {
    fun NavGraphBuilder.naviation(navController: NavHostController, destinations: Destinations)
}