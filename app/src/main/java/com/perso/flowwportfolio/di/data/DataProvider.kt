package com.perso.flowwportfolio.di.data

import androidx.compose.runtime.compositionLocalOf
import com.perso.flowwportfolio.di.HomeRepository

interface DataProvider {

}

val LocalDataProvider = compositionLocalOf<DataProvider> { error("No data provider found!") }