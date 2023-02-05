package com.perso.flowwportfolio.modules.settings

import com.perso.flowwportfolio.navigation.ComposableFeatureEntry

abstract class SettingsEntry : ComposableFeatureEntry {
    final override val featureRoute = "settings"

    fun destination() = featureRoute
}