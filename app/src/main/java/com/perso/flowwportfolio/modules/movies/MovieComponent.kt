package com.perso.flowwportfolio.modules.movies

import com.perso.flowwportfolio.di.CommonProvider
import com.perso.flowwportfolio.di.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [CommonProvider::class],
    modules = [MoviesModule::class]
)
interface MovieComponent: MovieProvider {
    val viewModel: MovieViewModel
}