package com.codebox.speedrun.domain.data.repo.developers.model

import com.speedrun.domain.repo.common.model.LinkModel

data class DeveloperModel(
    val id: String,
    val name: String,
    val links: List<LinkModel>
)
