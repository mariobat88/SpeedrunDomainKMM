package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.CategoryEntity
import com.codebox.speedrun.domain.data.database.CategoryPlayerEntity
import com.codebox.speedrun.domain.data.database.ObserveCategoriesByGameId
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertCategories(categories: List<CategoryEntity>) {
        dbQuery.transaction {
            categories.forEach {
                dbQuery.upsertCategory(
                    category_id = it.category_id,
                    category_name = it.category_name,
                    category_weblink = it.category_weblink,
                    category_type = it.category_type,
                    category_rules = it.category_rules,
                    category_miscellaneous = it.category_miscellaneous,
                    category_gameId = it.category_gameId
                )
            }
        }
    }

    fun upsertCategoryPlayer(categoryPlayers: List<CategoryPlayerEntity>) {
        dbQuery.transaction {
            categoryPlayers.forEach { categoryPlayer ->
                dbQuery.upsertCategoryPlayer(
                    categoryPlayer_categoryId = categoryPlayer.categoryPlayer_categoryId,
                    categoryPlayer_type = categoryPlayer.categoryPlayer_type,
                    categoryPlayer_value = categoryPlayer.categoryPlayer_value
                )
            }
        }
    }

    fun observeCategoriesByGameId(gameId: String): Flow<List<ObserveCategoriesByGameId>> {
        return dbQuery.observeCategoriesByGameId(gameId).asFlow().map { it.executeAsList() }
    }
}
