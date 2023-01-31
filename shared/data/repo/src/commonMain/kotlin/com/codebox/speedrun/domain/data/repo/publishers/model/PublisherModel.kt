package com.codebox.speedrun.domain.data.repo.publishers.model

import com.speedrun.domain.repo.common.model.LinkModel

data class PublisherModel(
    val id: String,
    val name: String,
    val links: List<LinkModel>
)
