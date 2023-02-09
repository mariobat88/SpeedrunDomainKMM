package com.codebox.speedrun.domain.data.datasource.categories.mapper

import com.codebox.speedrun.domain.data.database.CategoryEntity
import com.codebox.speedrun.domain.data.database.CategoryPlayerEntity
import com.codebox.speedrun.domain.data.database.ObserveCategoriesByGameId
import com.codebox.speedrun.domain.data.repo.model.CategoryModel
import com.codebox.speedrun.domain.networking.api.categories.models.CategoryResponse

fun CategoryResponse.toEntity(gameId: String) = CategoryEntity(
    category_id = id,
    category_miscellaneous = miscellaneous,
    category_name = name,
    category_rules = rules,
    category_type = type,
    category_weblink = weblink,
    category_gameId = gameId,
)

fun CategoryResponse.Players.toEntity(categoryId: String) = CategoryPlayerEntity(
    categoryPlayer_categoryId = categoryId,
    categoryPlayer_type = type,
    categoryPlayer_value = value.toLong(),
)

fun ObserveCategoriesByGameId.toCategoryModel() = CategoryModel(
    id = category_id,
    links = emptyList(),
    miscellaneous = category_miscellaneous,
    name = category_name,
    players = CategoryModel.Players(
        type = categoryPlayer_type!!,
        value = categoryPlayer_value?.toInt()!!,
    ),
    rules = category_rules,
    type = category_type,
    weblink = category_weblink,
    variables = emptyList()
)
