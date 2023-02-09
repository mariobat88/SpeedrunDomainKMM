package com.codebox.speedrun.domain.networking.api.leaderboards.models

import com.codebox.speedrun.domain.data.common.enums.RunTimeEnum
import com.codebox.speedrun.domain.networking.api.categories.models.CategoryDataResponse
import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import com.codebox.speedrun.domain.networking.api.players.models.PlayerResponse
import com.codebox.speedrun.domain.networking.api.runs.models.FlatRunResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LeaderboardResponse(
    @SerialName(value = "data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName(value = "weblink")
        val weblink: String,
        @SerialName(value = "game")
        val game: String,
        @SerialName(value = "category")
        val category: CategoryDataResponse,
        @SerialName(value = "level")
        val level: String?,
        @SerialName(value = "platform")
        val platform: String?,
        @SerialName(value = "region")
        val region: String?,
        @SerialName(value = "emulators")
        val emulators: Boolean?,
        @SerialName(value = "video-only")
        val videoOnly: Boolean,
        @SerialName(value = "timing")
        val timing: RunTimeEnum,
        @SerialName(value = "runs")
        val runs: List<LeaderboardRun>,
        @SerialName(value = "links")
        val links: List<LinkResponse>,
        @SerialName(value = "players")
        val players: Players,
        @SerialName(value = "variables")
        val variables: VariablesDataListResponse
    ) {
        @Serializable
        data class LeaderboardRun(
            @SerialName(value = "place")
            val place: Int,
            @SerialName(value = "run")
            val run: FlatRunResponse,
        )

        @Serializable
        data class Players(
            @SerialName(value = "data")
            val data: List<PlayerResponse>,
        )
    }
}
