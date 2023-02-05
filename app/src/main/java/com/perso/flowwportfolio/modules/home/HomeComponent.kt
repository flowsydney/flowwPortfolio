package com.perso.flowwportfolio.modules.home

import com.perso.flowwportfolio.di.CommonProvider
import com.perso.flowwportfolio.di.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [CommonProvider::class],
    modules = [HomeModule::class]
)
interface HomeComponent : HomeProvider {
    val viewModel: HomeViewModel
}