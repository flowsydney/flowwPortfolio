package com.perso.flowwportfolio.di

import com.perso.flowwportfolio.modules.home.HomeModule
import com.perso.flowwportfolio.modules.movies.MoviesModule
import com.perso.flowwportfolio.modules.news.NewsModule
import com.perso.flowwportfolio.modules.settings.SettingsModule
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module(
    includes = [
        HomeModule::class,
        SettingsModule::class,
        MoviesModule::class,
        NewsModule::class,
    ]
)
interface NavigationModule