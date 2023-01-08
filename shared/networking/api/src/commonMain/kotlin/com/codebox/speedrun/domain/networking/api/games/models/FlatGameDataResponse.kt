package com.codebox.speedrun.domain.networking.api.games.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlatGameDataResponse(
    @SerialName(value = "data") val data: FlatGameResponse,
)
