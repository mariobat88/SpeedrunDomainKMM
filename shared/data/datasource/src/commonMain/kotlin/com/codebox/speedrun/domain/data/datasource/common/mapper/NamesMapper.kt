package com.codebox.speedrun.domain.data.datasource.common.mapper

import com.codebox.speedrun.domain.data.repo.common.model.NamesModel
import com.codebox.speedrun.domain.networking.api.players.models.NamesResponse

fun NamesResponse.toModel() = NamesModel(
    international = international,
    japanese = japanese,
    twitch = twitch,
)
