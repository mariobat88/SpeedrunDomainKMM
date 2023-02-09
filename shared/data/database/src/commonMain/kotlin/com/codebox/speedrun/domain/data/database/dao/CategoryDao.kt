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

    fun upsertCategory(category: CategoryEntity) {
        dbQuery.transaction {
            dbQuery.upsertCategory(
                category_id = category.category_id,
                category_name = category.category_name,
                category_weblink = category.category_weblink,
                category_type = category.category_type,
                category_rules = category.category_rules,
                category_miscellaneous = category.category_miscellaneous,
                category_gameId = category.category_gameId
            )
        }
    }

    fun upsertCategories(categories: List<CategoryEntity>) {
        dbQuery.transaction { categories.forEach { upsertCategory(it) } }
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
