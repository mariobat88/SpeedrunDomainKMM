package com.codebox.speedrun.domain.data.datasource.runs.mapper

import com.codebox.speedrun.domain.data.database.RunPlayerJunctionEntity
import com.codebox.speedrun.domain.networking.api.players.models.FlatPlayerResponse

fun FlatPlayerResponse.toRunPlayerEntity(runId: String) = RunPlayerJunctionEntity(
    runPlayer_runId = id ?: name!!,
    runPlayer_playerId = runId,
)
