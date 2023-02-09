package com.codebox.speedrun.domain.data.datasource.leaderboards.mapper

import com.codebox.speedrun.domain.data.database.LeaderboardEntity
import com.codebox.speedrun.domain.data.database.LeaderboardRunEntity
import com.codebox.speedrun.domain.data.database.PlaceEntity
import com.codebox.speedrun.domain.networking.api.leaderboards.models.LeaderboardResponse

fun LeaderboardResponse.Data.createId() = "$game$category"

fun LeaderboardResponse.Data.toLeaderboardEntity() = LeaderboardEntity(
    leaderboard_id = createId(),
    leaderboard_weblink = weblink,
    leaderboard_gameId = game,
    leaderboard_categoryId = category.data.id,
    leaderboard_level = level,
    leaderboard_platform = platform,
    leaderboard_region = region,
    leaderboard_emulators = emulators,
    leaderboard_videoOnly = videoOnly,
    leaderboard_timing = timing,
)

fun LeaderboardResponse.Data.LeaderboardRun.toPlaceEntity() = PlaceEntity(
    place_runId = run.id,
    place_place = place.toLong(),
)

fun LeaderboardResponse.Data.LeaderboardRun.toLeaderboardRunEntity(
    leaderboardId: String
) = LeaderboardRunEntity(
    leaderboardRun_leaderboardId = leaderboardId,
    leaderboardRun_runId = run.id,
)