package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase
import com.codebox.speedrun.domain.data.database.ValueEntity

class ValueDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    private fun upsertValue(value: ValueEntity) {
        dbQuery.transaction {
            dbQuery.upsertValue(
                value_id = value.value_id,
                value_label = value.value_label,
            )
        }
    }

    fun upsertValues(runValues: List<ValueEntity>) {
        dbQuery.transaction { runValues.forEach { upsertValue(it) } }
    }
}
