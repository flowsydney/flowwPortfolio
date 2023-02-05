package com.perso.flowwportfolio.di.data

import com.perso.flowwportfolio.di.CommonProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CommonProvider::class],
)
interface DataComponent : DataProvider