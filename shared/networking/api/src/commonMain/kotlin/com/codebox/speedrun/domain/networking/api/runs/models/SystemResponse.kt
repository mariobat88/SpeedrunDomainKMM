package com.codebox.speedrun.domain.networking.api.runs.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SystemResponse(
    @SerialName(value = "platform") val platform: String?,
    @SerialName(value = "emulated") val emulated: Boolean,
    @SerialName(value = "region") val region: String?
)
