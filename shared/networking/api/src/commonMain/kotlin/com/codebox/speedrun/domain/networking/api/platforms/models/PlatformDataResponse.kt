package com.codebox.speedrun.domain.networking.api.platforms.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformDataResponse(
    @SerialName(value = "data") val data: List<PlatformResponse>
)