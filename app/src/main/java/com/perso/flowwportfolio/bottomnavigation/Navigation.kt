package com.perso.flowwportfolio.bottomnavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.perso.flowwportfolio.navigation.find
import com.perso.flowwportfolio.di.localAppProvider
import com.perso.flowwportfolio.modules.home.HomeEntry
import com.perso.flowwportfolio.modules.settings.SettingsEntry


@Composable
fun Navigation() {
    val navController = rememberNavController()

    val destinations = localAppProvider.current.destinations
    val homeScreen = destinations.find<HomeEntry>()
    val settingsScreen = destinations.find<SettingsEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {

            with(homeScreen) {
                composable(navController, destinations)
            }
            with(settingsScreen) {
                composable(navController, destinations)
            }
        }
    }
    Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
        BottomMenuBar(navController = navController, destinations = destinations)
    }
}