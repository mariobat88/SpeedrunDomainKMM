package com.codebox.speedrun.domain.data.datasource.developers.mapper

import com.codebox.speedrun.domain.data.database.DeveloperEntity
import com.codebox.speedrun.domain.data.repo.developers.model.DeveloperModel
import com.codebox.speedrun.domain.networking.api.developers.models.DeveloperResponse

fun DeveloperResponse.Data.toDeveloperEntity() = DeveloperEntity(
    developer_id = id,
    developer_name = name,
)

fun DeveloperEntity.toDeveloperModel() = DeveloperModel(
    id = developer_id,
    name = developer_name,
    links = emptyList()
)
