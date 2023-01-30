package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.RunTimeEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class RunTimeDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertRunTimes(runTimes: List<RunTimeEntity>) {
        dbQuery.transaction {
            runTimes.forEach {
                dbQuery.upsertRunTime(
                    runTime = it.runTime
                )
            }
        }
    }
}
