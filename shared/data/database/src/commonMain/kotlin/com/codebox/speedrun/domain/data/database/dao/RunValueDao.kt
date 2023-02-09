package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.RunValueJunctionEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class RunValueDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    private fun upsertRunValue(runValue: RunValueJunctionEntity) {
        dbQuery.transaction {
            dbQuery.upsertRunValue(
                runValue_runId = runValue.runValue_runId,
                runValue_variableId = runValue.runValue_variableId,
                runValue_valueId = runValue.runValue_valueId,
            )
        }
    }


    fun upsertRunValues(runValues: List<RunValueJunctionEntity>) {
        dbQuery.transaction { runValues.forEach { upsertRunValue(it) } }
    }
}
