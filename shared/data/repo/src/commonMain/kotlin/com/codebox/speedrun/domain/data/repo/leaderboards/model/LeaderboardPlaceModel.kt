package com.codebox.speedrun.domain.data.repo.leaderboards.model

import com.codebox.speedrun.domain.data.repo.runs.model.RunModel

data class LeaderboardPlaceModel(
    val place: Int?,
    val run: RunModel?,
)
