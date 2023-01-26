package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.CategoryEntity
import com.codebox.speedrun.domain.data.database.CategoryPlayerEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class CategoryDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertCategories(categories: List<CategoryEntity>) {
        dbQuery.transaction {
            categories.forEach {
                dbQuery.upsertCategory(
                    id = it.id,
                    name = it.name,
                    weblink = it.weblink,
                    type = it.type,
                    rules = it.rules,
                    miscellaneous = it.miscellaneous,
                    gameId = it.gameId
                )
            }
        }
    }

    fun upsertCategoryPlayer(categoryPlayers: List<CategoryPlayerEntity>) {
        dbQuery.transaction {
            categoryPlayers.forEach { categoryPlayer ->
                dbQuery.upsertCategoryPlayer(
                    categoryId = categoryPlayer.categoryId,
                    type = categoryPlayer.type,
                    value_ = categoryPlayer.value_
                )
            }
        }
    }
}
