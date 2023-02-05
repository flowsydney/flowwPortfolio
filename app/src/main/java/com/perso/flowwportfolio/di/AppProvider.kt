package com.perso.flowwportfolio.di

import androidx.compose.runtime.compositionLocalOf
import com.perso.flowwportfolio.di.data.DataProvider
import com.perso.flowwportfolio.navigation.Destinations

interface AppProvider : CommonProvider {
    val destinations: Destinations
}

val localAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }