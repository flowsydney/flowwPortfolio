package com.perso.flowwportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import com.perso.flowwportfolio.bottomnavigation.Navigation
import com.perso.flowwportfolio.di.localAppProvider
import com.perso.flowwportfolio.di.localCommonProvider
import com.perso.flowwportfolio.ui.theme.FlowwPortfolioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowwPortfolioTheme {
                CompositionLocalProvider(
                    localAppProvider provides application.appProvider,
                    localCommonProvider provides application.appProvider
                ) {
                    Navigation()
                }
            }
        }
    }
}
