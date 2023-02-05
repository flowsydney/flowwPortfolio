package com.perso.flowwportfolio.modules.home

import com.perso.flowwportfolio.navigation.ComposableFeatureEntry

abstract class HomeEntry: ComposableFeatureEntry {
    final override val featureRoute = "home"

    fun destination() = featureRoute
}