package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class DeveloperDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertDeveloper(developer: DeveloperEntity) {
        dbQuery.transaction {
            dbQuery.upsertDeveloper(
                developer_id = developer.developer_id,
                developer_name = developer.developer_name,
            )
        }
    }
}
