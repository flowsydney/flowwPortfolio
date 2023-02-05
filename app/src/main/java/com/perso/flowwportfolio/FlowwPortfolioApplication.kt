package com.perso.flowwportfolio

import android.app.Application
import com.perso.flowwportfolio.di.AppProvider
import com.perso.flowwportfolio.di.DaggerAppComponent
import com.perso.flowwportfolio.di.DaggerCommonComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FlowwPortfolioApplication: Application() {
    lateinit var appProvider: AppProvider
        private set

    override fun onCreate() {
        super.onCreate()
        val commonProvider = DaggerCommonComponent.factory().create(this)
        appProvider = DaggerAppComponent.builder()
            .commonProvider(commonProvider)
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as FlowwPortfolioApplication).appProvider