package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.CategoryEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class CategoryDao(
    database: SpeedrunDomainDatabase
) {

    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertCategories(categories: List<CategoryEntity>) {
        dbQuery.transaction {
            categories.forEach {
                dbQuery.upsertCategory(
                    it.id,
                    it.name,
                    it.weblink,
                    it.type,
                    it.rules,
                    it.miscellaneous,
                    it.gameId
                )
            }
        }
    }
}