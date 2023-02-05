package com.perso.flowwportfolio.di

import android.content.Context
import androidx.compose.runtime.compositionLocalOf
import com.perso.flowwportfolio.di.CommonModule.IO
import kotlinx.coroutines.CoroutineDispatcher

import javax.inject.Named

interface CommonProvider {
    val context: Context

    @get:Named(IO)
    val ioDispatcher: CoroutineDispatcher
}

val localCommonProvider = compositionLocalOf<CommonProvider> { error("No common provider found!") }