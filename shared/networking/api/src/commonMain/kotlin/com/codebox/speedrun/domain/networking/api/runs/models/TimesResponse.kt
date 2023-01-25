package com.codebox.speedrun.domain.networking.api.runs.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimesResponse(
    @SerialName(value = "primary") val primary: String,
    @SerialName(value = "primary_t") val primaryT: Float,
    @SerialName(value = "realtime") val realtime: String?,
    @SerialName(value = "realtime_t") val realtimeT: Float,
    @SerialName(value = "realtime_noloads") val realtimeNoLoads: String?,
    @SerialName(value = "realtime_noloads_t") val realtimeNoLoadsT: Float,
    @SerialName(value = "ingame") val ingame: String?,
    @SerialName(value = "ingame_t") val ingameT: Float
)