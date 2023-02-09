package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase
import com.codebox.speedrun.domain.data.database.ValueEntity
import com.codebox.speedrun.domain.data.database.VariableEntity

class VariableDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    private fun upsertVariable(variable: VariableEntity) {
        dbQuery.transaction {
            dbQuery.upsertVariable(
                variable_id = variable.variable_id,
                variable_name = variable.variable_name,
                variable_categoryId = variable.variable_categoryId,
                variable_scope = variable.variable_scope,
                variable_mandatory = variable.variable_mandatory,
                variable_userDefined = variable.variable_userDefined,
                variable_obsoletes = variable.variable_obsoletes,
                variable_isSubcategory = variable.variable_isSubcategory,
            )
        }
    }

    fun upsertVariables(variables: List<VariableEntity>) {
        dbQuery.transaction { variables.forEach { upsertVariable(it) } }
    }
}
