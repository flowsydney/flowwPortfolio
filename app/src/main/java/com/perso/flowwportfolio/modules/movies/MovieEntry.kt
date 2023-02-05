package com.perso.flowwportfolio.modules.movies

import com.perso.flowwportfolio.navigation.ComposableFeatureEntry

abstract class MovieEntry : ComposableFeatureEntry {
    final override val featureRoute = "movies"

    fun destination() = featureRoute
}