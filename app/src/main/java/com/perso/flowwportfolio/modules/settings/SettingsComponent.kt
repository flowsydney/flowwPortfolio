package com.perso.flowwportfolio.modules.settings

import com.perso.flowwportfolio.di.CommonProvider
import com.perso.flowwportfolio.di.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [CommonProvider::class],
    modules = [SettingsModule::class]
)
interface SettingsComponent : SettingsProvider {
    val viewModel: SettingsViewModel
}