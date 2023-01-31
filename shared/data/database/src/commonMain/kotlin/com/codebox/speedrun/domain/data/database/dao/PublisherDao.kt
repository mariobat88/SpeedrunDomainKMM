package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class PublisherDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertPublisher(publisher: PublisherEntity) {
        dbQuery.transaction {
            dbQuery.upsertPublisher(
                id = publisher.id,
                name = publisher.name,
            )
        }
    }
}
