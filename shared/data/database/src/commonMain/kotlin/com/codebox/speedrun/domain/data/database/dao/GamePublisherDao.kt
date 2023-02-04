package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class GamePublisherDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertGamePublishers(gamePublishers: List<GamePublisherEntity>) {
        dbQuery.transaction {
            gamePublishers.forEach {
                dbQuery.upsertGamePublisher(
                    gamePublisher_gameId = it.gamePublisher_gameId,
                    gamePublisher_publisherId = it.gamePublisher_publisherId
                )
            }
        }
    }
}
