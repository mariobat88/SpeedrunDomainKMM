package com.codebox.speedrun.domain.data.datasource.publishers.mapper

import com.codebox.speedrun.domain.data.database.PublisherEntity
import com.codebox.speedrun.domain.data.repo.publishers.model.PublisherModel
import com.codebox.speedrun.domain.networking.api.publishers.models.PublisherResponse

fun PublisherResponse.Data.toPublisherEntity() = PublisherEntity(
    publisher_id = id,
    publisher_name = name,
)

fun PublisherEntity.toPublisherModel() = PublisherModel(
    id = publisher_id,
    name = publisher_name,
    links = emptyList()
)
