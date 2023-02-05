package com.perso.flowwportfolio.modules.news

import com.perso.flowwportfolio.di.CommonComponent
import com.perso.flowwportfolio.di.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [CommonComponent::class],
    modules = [NewsModule::class],
)
interface NewsComponent: NewsProvider {
    val viewModel: NewsViewModel
}