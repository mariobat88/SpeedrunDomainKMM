package com.codebox.speedrun.domain.data.datasource.publishers.mapper

import com.codebox.speedrun.domain.data.database.PublisherEntity
import com.codebox.speedrun.domain.data.repo.publishers.model.PublisherModel
import com.codebox.speedrun.domain.networking.api.publishers.models.PublisherResponse

fun PublisherResponse.Data.toPublisherEntity() = PublisherEntity(
    id = id,
    name = name,
)

fun PublisherEntity.toPublisherModel() = PublisherModel(
    id = id,
    name = name,
    links = emptyList()
)
