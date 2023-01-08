package com.codebox.speedrun.domain.data.datasource.common.mapper

import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import com.speedrun.domain.repo.common.model.LinkModel

fun LinkResponse.toModel() = LinkModel(
    rel = rel,
    uri = uri
)
