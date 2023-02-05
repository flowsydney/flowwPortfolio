package com.perso.flowwportfolio.modules.settings

import com.perso.flowwportfolio.di.FeatureEntryKey
import com.perso.flowwportfolio.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@DisableInstallInCheck
@Module
interface SettingsModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(SettingsEntry::class)
    fun settingsEntry(entry: SettingsEntryImpl): FeatureEntry
}