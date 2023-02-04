package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class PublisherDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertPublisher(publisher: PublisherEntity) {
        dbQuery.transaction {
            dbQuery.upsertPublisher(
                publisher_id = publisher.publisher_id,
                publisher_name = publisher.publisher_name,
            )
        }
    }
}
