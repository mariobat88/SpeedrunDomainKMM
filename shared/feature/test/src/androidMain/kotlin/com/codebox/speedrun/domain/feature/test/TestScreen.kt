package com.codebox.speedrun.domain.feature.test

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TestScreen() {
    val viewModel = koinViewModel<TestViewModel>()
}