package com.codebox.speedrun.domain.networking.api.players.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesResponse(
    @SerialName(value = "international") val international: String,
    @SerialName(value = "japanese") val japanese: String? = null
)
