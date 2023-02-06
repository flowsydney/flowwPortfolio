package com.perso.flowwportfoliohilt.ui

import androidx.compose.runtime.*
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.core.os.trace
import com.perso.flowwportfoliohilt.home.navigateToHome
import com.perso.flowwportfoliohilt.movies.navigateToMovies
import com.perso.flowwportfoliohilt.navigation.BaseDestination
import com.perso.flowwportfoliohilt.news.navigateToNews
import com.perso.flowwportfoliohilt.settings.navigateToSettings
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberPortfolioAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
) : PortfolioAppState {
    return remember(navController, coroutineScope, windowSizeClass) {
        PortfolioAppState(navController, coroutineScope, windowSizeClass)
    }
}

@Stable
class PortfolioAppState( val navController: NavHostController,
                         val coroutineScope: CoroutineScope,
                         val windowSizeClass: WindowSizeClass) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    var shouldShowSettingsDialog by mutableStateOf(false)
        private set

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

//    val isOffline = networkMonitor.isOnline
//        .map(Boolean::not)
//        .stateIn(
//            scope = coroutineScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = false,
//        )

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<BaseDestination> = BaseDestination.values().asList()

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: BaseDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                BaseDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
                BaseDestination.MOVIES -> navController.navigateToMovies(topLevelNavOptions)
                BaseDestination.NEWS -> navController.navigateToNews(topLevelNavOptions)
                BaseDestination.SETTINGS -> navController.navigateToSettings(topLevelNavOptions)
            }
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }

    fun setShowSettingsDialog(shouldShow: Boolean) {
        shouldShowSettingsDialog = shouldShow
    }
}