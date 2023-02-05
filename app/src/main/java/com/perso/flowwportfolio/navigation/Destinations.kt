package com.perso.flowwportfolio.navigation

typealias Destinations = Map<Class<out FeatureEntry>, @JvmSuppressWildcards FeatureEntry>

inline fun <reified T : FeatureEntry> Destinations.find(): T = this[T::class.java] as T