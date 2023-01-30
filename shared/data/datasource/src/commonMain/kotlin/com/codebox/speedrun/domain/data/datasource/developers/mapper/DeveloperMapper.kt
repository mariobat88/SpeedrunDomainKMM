package com.codebox.speedrun.domain.data.datasource.developers.mapper

import com.codebox.speedrun.domain.data.database.DeveloperEntity
import com.codebox.speedrun.domain.data.repo.developers.model.DeveloperModel
import com.codebox.speedrun.domain.networking.api.developers.models.DeveloperResponse

fun DeveloperResponse.Data.toDeveloperEntity() = DeveloperEntity(
    id = id,
    name = name,
)

fun DeveloperEntity.toDeveloperModel() = DeveloperModel(
    id = id,
    name = name,
    links = emptyList()
)
