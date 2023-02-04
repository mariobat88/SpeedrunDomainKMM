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
                    platform_id = it.platform_id,
                    platform_name = it.platform_name,
                    platform_released = it.platform_released,
                )
            }
        }
    }
}
