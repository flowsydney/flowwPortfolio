package com.perso.flowwportfolio.di

import com.perso.flowwportfolio.navigation.FeatureEntry
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)