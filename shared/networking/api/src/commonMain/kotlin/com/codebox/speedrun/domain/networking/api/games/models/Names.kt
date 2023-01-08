package com.codebox.speedrun.domain.networking.api.games.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Names(
    @SerialName(value = "international") val international: String,
    @SerialName(value = "japanese") val japanese: String?,
    @SerialName(value = "twitch") val twitch: String?
)
