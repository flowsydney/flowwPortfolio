package com.perso.flowwportfolio.modules.home

import com.perso.flowwportfolio.di.FeatureEntryKey
import com.perso.flowwportfolio.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@DisableInstallInCheck
@Module
interface HomeModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(HomeEntry::class)
    fun homeEntry(entry: HomeEntryImpl): FeatureEntry
}