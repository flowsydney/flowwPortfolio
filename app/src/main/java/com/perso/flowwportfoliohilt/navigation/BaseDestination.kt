package com.perso.flowwportfoliohilt.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.perso.flowwportfoliohilt.R

enum class BaseDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int
) {
    HOME(
       selectedIcon =  Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.home,
        titleTextId = R.string.home
    ),
    MOVIES(
        selectedIcon =  Icons.Rounded.Face,
        unselectedIcon = Icons.Outlined.Face,
        iconTextId = R.string.movies,
        titleTextId = R.string.movies
    ),
    NEWS(
        selectedIcon =  Icons.Rounded.List,
        unselectedIcon = Icons.Outlined.List,
        iconTextId = R.string.news,
        titleTextId = R.string.news
    ),
    SETTINGS(
        selectedIcon =  Icons.Rounded.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        iconTextId = R.string.settings,
        titleTextId = R.string.settings
    )

}