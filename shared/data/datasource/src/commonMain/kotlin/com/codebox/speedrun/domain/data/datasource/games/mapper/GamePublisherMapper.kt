package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.database.GamePublisherEntity
import com.codebox.speedrun.domain.networking.api.games.models.GameResponse

fun GameResponse.toGamePublisherEntity() : List<GamePublisherEntity>{
    return publishers.map { GamePublisherEntity(this.id, it) }
}
