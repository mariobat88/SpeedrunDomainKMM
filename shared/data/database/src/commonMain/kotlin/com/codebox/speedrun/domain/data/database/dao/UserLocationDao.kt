package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class UserLocationDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertUserLocations(userLocations: List<UserLocationEntity>) {
        dbQuery.transaction {
            userLocations.forEach {
                dbQuery.upsertUserLocation(
                    userId = it.userId,
                    locationId = it.locationId,
                )
            }
        }
    }
}
