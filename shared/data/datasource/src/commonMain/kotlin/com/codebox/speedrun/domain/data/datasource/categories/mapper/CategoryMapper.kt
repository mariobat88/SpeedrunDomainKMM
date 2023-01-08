package com.codebox.speedrun.domain.data.datasource.categories.mapper

import com.codebox.speedrun.domain.data.database.CategoryEntity
import com.codebox.speedrun.domain.networking.api.categories.models.CategoryResponse

fun CategoryResponse.toEntity(gameId: String) = CategoryEntity(
    id = id,
    miscellaneous = miscellaneous,
    name = name,
    //players = players.toEntity(),
    rules = rules,
    type = "",
    weblink = weblink,
    gameId = gameId,
)
