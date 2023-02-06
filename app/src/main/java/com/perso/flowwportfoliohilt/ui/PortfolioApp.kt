package com.perso.flowwportfoliohilt.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.perso.flowwportfoliohilt.navigation.AppNavHost
import com.perso.flowwportfoliohilt.navigation.BaseDestination
import com.perso.flowwportfoliohilt.ui.components.PortfolioBackground

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
fun PortfolioApp(
    windowSizeClass: WindowSizeClass,
    appState: PortfolioAppState =
        rememberPortfolioAppState(
            windowSizeClass = windowSizeClass,
        )
) {
    PortfolioBackground {
//        val isOffline = appState.isOffline.collectAsState()

        Scaffold(modifier = Modifier.semantics {
            testTagsAsResourceId = true
        }, containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            bottomBar = {
                FPBottomBar(destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier
                        .testTag("FPNavRails")
                        .safeDrawingPadding())
            }) {padding ->
            val pad = padding
            AppNavHost(navController = appState.navController, onBackClick = appState::onBackClick)
        }
    }
}

@Composable
fun FPBottomBar(
    destinations: List<BaseDestination>,
    onNavigateToDestination: (BaseDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    FPNavigationBar(modifier = modifier) {
        destinations.forEach { destinations ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destinations)
            FPNavigationBarItem(selected = selected,
                onClick = { onNavigateToDestination(destinations) },
                icon = {
                    destinations.unselectedIcon
                },
                label = { Text(stringResource(id = destinations.iconTextId)) },
                selectedIcon = { destinations.selectedIcon }
            )
        }
    }
}

@Composable
fun RowScope.FPNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label, alwaysShowLabel = alwaysShowLabel
    )
}

@Composable
fun FPNavigationRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = FPNavigationDefaults.navigationContentColor(),
        header = header,
        content = content,
    )
}


@Composable
fun FPNavRails(
    destinations: List<BaseDestination>,
    onNavigateToDestination: (BaseDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    FPNavigationRail(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NiaNavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                   if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) },
            )
        }
    }
}

@Composable
fun NiaNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = FPNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = FPNavigationDefaults.navigationContentColor(),
            selectedTextColor = FPNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = FPNavigationDefaults.navigationContentColor(),
            indicatorColor = FPNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

@Composable
fun FPNavigationBar(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    NavigationBar(modifier = modifier, content = content)
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: BaseDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

object FPNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
