package com.perso.flowwportfolio.di

import com.perso.flowwportfolio.modules.home.HomeModule
import com.perso.flowwportfolio.modules.settings.SettingsModule
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module(
    includes = [
        HomeModule::class,
        SettingsModule::class,
    ]
)
interface NavigationModule