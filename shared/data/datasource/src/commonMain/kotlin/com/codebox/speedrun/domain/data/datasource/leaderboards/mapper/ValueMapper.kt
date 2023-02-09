package com.codebox.speedrun.domain.data.datasource.leaderboards.mapper

import com.codebox.speedrun.domain.data.database.ValueEntity
import com.codebox.speedrun.domain.networking.api.leaderboards.models.VariablesResponse

fun VariablesResponse.toValueEntities() : List<ValueEntity>{
    return values.values.map {
        ValueEntity(
            value_id = it.key,
            value_label = it.value.label
        )
    }
}