package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.database.GameRunTimeEntity
import com.codebox.speedrun.domain.networking.api.games.models.GameResponse

fun GameResponse.toGameRunTimeEntity() : List<GameRunTimeEntity>{
    return ruleset.runTimes.map { GameRunTimeEntity(id, it) }
}
