package com.perso.flowwportfolio.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.perso.flowwportfolio.modules.home.HomeEntry
import com.perso.flowwportfolio.modules.home.HomeModule
import com.perso.flowwportfolio.modules.settings.SettingsEntry
import com.perso.flowwportfolio.modules.settings.SettingsModule
import com.perso.flowwportfolio.navigation.Destinations
import com.perso.flowwportfolio.navigation.find
import com.perso.flowwportfolio.ui.GlowingMenuIcon
import com.perso.flowwportfolio.ui.glow

@Composable
fun BottomMenuBar(
    navController: NavController,
    destinations: Destinations
) {
    BottomNavigationLayout {
        GlowingMenuIcon(isGlowing = true,
            glowingIcon = Icons.Rounded.Home,
            idleIcon = Icons.Outlined.Home,
        modifier = Modifier.clickable(indication = rememberRipple(bounded = false),
            interactionSource = remember { MutableInteractionSource() }) {
            val route = destinations.find<HomeEntry>().featureRoute
            navController.popBackStack(route, inclusive = false)
        })
        Box(contentAlignment = Alignment.Center) {
            GlowingMenuIcon(isGlowing = false,
                glowingIcon = Icons.Rounded.Settings,
                idleIcon = Icons.Outlined.Settings, modifier = Modifier.clickable {
                    val route = destinations.find<SettingsEntry>().featureRoute
                    navController.navigate(route)
                })
        }
    }
}

@Composable
private inline fun BottomNavigationLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(70.dp)
            .glow(Color.DarkGray, radius = 20.dp, alpha = 0.9f, offsetY = 10.dp)
            .clip(RoundedCornerShape(topStartPercent = 40, topEndPercent = 40))
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}