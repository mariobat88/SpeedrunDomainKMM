package com.codebox.speedrun.domain.feature.app

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.codebox.speedrun.domain.core.framework.speedrunViewModel
import com.codebox.speedrun.domain.feature.app.navigation.AppNavigation
import com.codebox.speedrun.domain.shared.feature.app.AppViewModel
import com.codebpx.speedrun.domain.core.designsystem.theme.DarkDefaultColorScheme
import com.codebpx.speedrun.domain.core.designsystem.theme.LightDefaultColorScheme

@Composable
fun AppScreen() {
    val darkTheme = isSystemInDarkTheme()
    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    val colorScheme = when {
        //dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        //dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkDefaultColorScheme
        else -> LightDefaultColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
    ) {
        val appViewModel = speedrunViewModel { AppViewModel.create() }
        val navController = rememberNavController()
        AppNavigation(navController, appViewModel)
    }
}
