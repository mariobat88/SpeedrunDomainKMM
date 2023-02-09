package com.codebox.speedrun.domain.data.datasource.leaderboards.mapper

import com.codebox.speedrun.domain.data.database.VariableEntity
import com.codebox.speedrun.domain.networking.api.leaderboards.models.VariablesResponse

fun VariablesResponse.toVariableEntity() = VariableEntity(
    variable_id = id,
    variable_name = name,
    variable_categoryId = category,
    variable_scope = scope.type,
    variable_mandatory = mandatory,
    variable_userDefined = userDefined,
    variable_obsoletes = obsoletes,
    variable_isSubcategory = isSubcategory,
)
