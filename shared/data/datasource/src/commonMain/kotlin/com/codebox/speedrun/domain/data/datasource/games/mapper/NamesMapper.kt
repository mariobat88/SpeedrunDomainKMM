package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.networking.api.games.models.Names

fun Names.toModel() = GameModel.Names(
    international = international,
    japanese = japanese,
    twitch = twitch,
)
