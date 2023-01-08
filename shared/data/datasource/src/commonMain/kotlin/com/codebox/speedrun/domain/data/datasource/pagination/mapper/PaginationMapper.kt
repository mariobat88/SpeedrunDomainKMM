package com.codebox.speedrun.domain.data.datasource.pagination.mapper

import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
import com.codebox.speedrun.domain.data.datasource.common.mapper.toModel

fun PaginationResponse.Pagination.toModel() = PaginationModel.Pagination(
    offset = offset,
    max = max,
    size = size,
    links = links.map { it.toModel() }
)
