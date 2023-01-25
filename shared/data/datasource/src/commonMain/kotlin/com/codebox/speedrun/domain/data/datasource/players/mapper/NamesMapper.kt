package com.codebox.speedrun.domain.data.datasource.players.mapper

import com.codebox.speedrun.domain.data.repo.players.model.NamesModel
import com.codebox.speedrun.domain.networking.api.players.models.NamesResponse

fun NamesResponse.toModel()  = NamesModel(
    international = international,
    japanese = japanese
)
