package com.perso.flowwportfolio.di

import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@DisableInstallInCheck
@Module
object CommonModule {
    const val IO = "IO"

    @Provides
    @Singleton
    @Named(IO)
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}