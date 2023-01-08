package com.codebox.speedrun.domain.feature.dashboard.feature.home

sealed class Intent

data class ViewState(
    val any: Any = Any()
)
