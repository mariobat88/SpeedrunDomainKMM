package com.codebox.speedrun.domain.data.datasource.leaderboards.mapper

import com.codebox.speedrun.domain.data.database.RunValueJunctionEntity
import com.codebox.speedrun.domain.networking.api.runs.models.FlatRunResponse

fun FlatRunResponse.toRunValueEntities(): List<RunValueJunctionEntity>? {
    return values?.mapNotNull {
        RunValueJunctionEntity(
            runValue_runId = id,
            runValue_variableId = it.key,
            runValue_valueId = it.value
        )
    }
}
