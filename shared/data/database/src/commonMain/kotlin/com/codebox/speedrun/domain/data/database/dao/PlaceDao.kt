package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.PlaceEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class PlaceDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertPlaces(places: List<PlaceEntity>) {
        dbQuery.transaction {
            places.forEach {
                dbQuery.upsertPlace(
                    place_runId = it.place_runId,
                    place_place = it.place_place,
                )
            }
        }
    }
}
