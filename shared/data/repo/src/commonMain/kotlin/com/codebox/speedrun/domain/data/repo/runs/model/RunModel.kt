package com.codebox.speedrun.domain.data.repo.runs.model

import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.model.CategoryModel
import com.codebox.speedrun.domain.data.repo.platforms.model.PlatformModel
import com.codebox.speedrun.domain.data.repo.players.model.PlayerModel
import com.speedrun.domain.repo.common.model.LinkModel

data class RunModel(
    val id: String,
    val weblink: String,
    val game: GameModel?,
    val level: String?,
    val category: CategoryModel?,
    val videos: List<String>,
    val comment: String?,
    val status: Status,
    val players: List<PlayerModel>,
    val date: String?,
    val submitted: String?,
    val times: Times,
    val system: System,
    val splits: Any?,
    val values: Map<String, String>?,
    val links: List<LinkModel>?
) {
    data class Status(
        val status: String,
        val examiner: String?,
        val verifyDate: String?
    )

    data class Times(
        val primary: String,
        val primaryT: Float,
        val realtime: String?,
        val realtimeT: Float,
        val realtimeNoLoads: String?,
        val realtimeNoLoadsT: Float,
        val ingame: String?,
        val ingameT: Float
    )

    data class System(
        val platform: PlatformModel?,
        val emulated: Boolean,
        val region: String?
    )
}
