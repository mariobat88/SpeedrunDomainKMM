package com.codebox.speedrun.domain.networking.api.leaderboards.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VariablesDataListResponse(
    @SerialName(value = "data")
    val data: List<VariablesResponse>
)
