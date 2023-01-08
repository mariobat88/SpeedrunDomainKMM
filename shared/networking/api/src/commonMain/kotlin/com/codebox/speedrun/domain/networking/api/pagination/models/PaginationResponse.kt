package com.codebox.speedrun.domain.networking.api.pagination.models

import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationResponse<T>(
    @SerialName(value = "data") val data: List<T>,
    @SerialName(value = "pagination") val pagination: Pagination,
) {
    @Serializable
    data class Pagination(
        @SerialName(value = "offset") val offset: Int,
        @SerialName(value = "max") val max: Int,
        @SerialName(value = "size") val size: Int,
        @SerialName(value = "links") val links: List<LinkResponse>
    )
}
