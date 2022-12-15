package com.codebox.speedrun.domain.networking.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDataListResponse(
    @SerialName(value = "data")
    val data: List<CategoryResponse>
)