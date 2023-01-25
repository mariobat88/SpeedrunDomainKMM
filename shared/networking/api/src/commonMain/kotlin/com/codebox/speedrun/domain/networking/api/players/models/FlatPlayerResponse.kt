package com.codebox.speedrun.domain.networking.api.players.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlatPlayerResponse(
    @SerialName(value = "rel") val rel: String,
    @SerialName(value = "id") val id: String?,
    @SerialName(value = "name") val name: String?,
    @SerialName(value = "uri") val uri: String,
)
