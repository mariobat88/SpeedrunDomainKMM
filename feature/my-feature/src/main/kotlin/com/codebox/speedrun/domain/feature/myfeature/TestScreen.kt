package com.codebox.speedrun.domain.feature.myfeature

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.codebox.speedrun.domain.di.SpeedrunApplicationEntryPoint
import com.codebox.speedrun.domain.feature.test.TestViewModel

@Composable
fun TestScreen() {
    val viewModel =
        TestViewModel.create((LocalContext.current.applicationContext as SpeedrunApplicationEntryPoint).appComponent)
}
