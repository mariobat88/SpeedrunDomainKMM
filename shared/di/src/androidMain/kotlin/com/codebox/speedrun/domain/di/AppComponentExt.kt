package com.codebox.speedrun.domain.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun appComponent(): AppComponent {
    return (LocalContext.current.applicationContext as SpeedrunApplicationEntryPoint).appComponent!!
}
