package com.perso.flowwportfolio.modules.news

import com.perso.flowwportfolio.navigation.ComposableFeatureEntry

abstract class NewsEntry : ComposableFeatureEntry {
    override val featureRoute = "news"

    fun destination() = featureRoute
}