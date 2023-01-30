package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class LocationDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertLocations(locations: List<LocationEntity>) {
        dbQuery.transaction {
            locations.forEach {
                dbQuery.upsertLocation(
                    id = it.id,
                    countryCode = it.countryCode,
                    countryInternational = it.countryInternational,
                    countryJapanese = it.countryJapanese,
                    regionCode = it.regionCode,
                    regionInternational = it.regionInternational,
                    regionJapanese = it.regionJapanese
                )
            }
        }
    }
}
