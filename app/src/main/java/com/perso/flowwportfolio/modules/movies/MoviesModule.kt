package com.perso.flowwportfolio.modules.movies

import com.perso.flowwportfolio.di.FeatureEntryKey
import com.perso.flowwportfolio.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@DisableInstallInCheck
@Module
interface MoviesModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(MovieEntry::class)
    fun movieEntry(entry: MovieEntryImpl): FeatureEntry
}