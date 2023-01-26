package com.codebox.speedrun.domain.data.datasource.categories.mapper

import com.codebox.speedrun.domain.data.database.CategoryEntity
import com.codebox.speedrun.domain.data.database.CategoryPlayerEntity
import com.codebox.speedrun.domain.networking.api.categories.models.CategoryResponse

fun CategoryResponse.toEntity(gameId: String) = CategoryEntity(
    id = id,
    miscellaneous = miscellaneous,
    name = name,
    rules = rules,
    type = "",
    weblink = weblink,
    gameId = gameId,
)

fun CategoryResponse.Players.toEntity(categoryId: String) = CategoryPlayerEntity(
    categoryId = categoryId,
    type = type,
    value_ = value.toLong(),
)
