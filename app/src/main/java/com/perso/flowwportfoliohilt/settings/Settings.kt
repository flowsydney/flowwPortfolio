package com.perso.flowwportfoliohilt.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


fun NavGraphBuilder.settingsScreen() {
    composable("settings") {
        val viewModel: SettingsViewModel = hiltViewModel()
        SettingsScreen()
    }
}

fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    this.navigate("settings")
}

@Composable
fun SettingsScreen() {
    Box {
        Text(text = "Settings")
    }
}