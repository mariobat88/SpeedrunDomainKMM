package com.codebox.speedrun.domain.networking.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDataResponse(
    @SerialName(value = "data")
    val data: CategoryResponse
)
