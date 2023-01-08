package com.codebox.speedrun.domain.networking.api.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkResponse(
    @SerialName(value = "rel") val rel: String?,
    @SerialName(value = "uri") val uri: String
)
