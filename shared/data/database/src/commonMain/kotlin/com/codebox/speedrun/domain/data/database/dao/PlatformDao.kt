package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class PlatformDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertPlatforms(platforms: List<PlatformEntity>) {
        dbQuery.transaction {
            platforms.forEach {
                dbQuery.upsertPlatform(
                    id = it.id,
                    name = it.name,
                    released = it.released,
                )
            }
        }
    }
}
