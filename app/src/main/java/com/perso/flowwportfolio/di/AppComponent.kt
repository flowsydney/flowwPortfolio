package com.perso.flowwportfolio.di

import com.perso.flowwportfolio.di.data.DataProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonProvider::class,
    ],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider