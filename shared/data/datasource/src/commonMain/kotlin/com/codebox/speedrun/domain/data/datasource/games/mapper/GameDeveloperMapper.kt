package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.database.GameDeveloperEntity
import com.codebox.speedrun.domain.networking.api.games.models.GameResponse

fun GameResponse.toGameDeveloperEntity() : List<GameDeveloperEntity>{
    return developers.map { GameDeveloperEntity(this.id, it) }
}
