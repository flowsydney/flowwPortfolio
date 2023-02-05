package com.perso.flowwportfolio.modules.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.perso.flowwportfolio.navigation.Destinations
import javax.inject.Inject

class SettingsEntryImpl @Inject constructor() : SettingsEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Text("settings")
        }
    }
}