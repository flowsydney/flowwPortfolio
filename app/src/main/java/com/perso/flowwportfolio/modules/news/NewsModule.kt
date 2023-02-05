package com.perso.flowwportfolio.modules.news

import com.perso.flowwportfolio.di.FeatureEntryKey
import com.perso.flowwportfolio.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@DisableInstallInCheck
@Module
interface NewsModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(NewsEntry::class)
    fun newsEntry(entry: NewsEntryImpl): FeatureEntry
}