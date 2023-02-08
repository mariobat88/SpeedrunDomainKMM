package com.codebox.speedrun.domain.data.repo.leaderboards.model

import com.codebox.speedrun.domain.data.common.enums.RunTimeEnum
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.model.CategoryModel
import com.speedrun.domain.repo.common.model.LinkModel

data class LeaderboardModel(
    val id: String,
    val weblink: String,
    val game: GameModel?,
    val category: CategoryModel?,
    val level: Any?,
    val platform: String?,
    val region: Any?,
    val emulators: Boolean?,
    val videoOnly: Boolean,
    val timing: RunTimeEnum,
    val runs: List<LeaderboardPlaceModel>,
    val links: List<LinkModel>
)
