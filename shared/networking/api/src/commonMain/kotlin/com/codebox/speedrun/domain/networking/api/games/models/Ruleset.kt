package com.codebox.speedrun.domain.networking.api.games.models

import com.codebox.speedrun.domain.data.common.enums.RunTimeEnum
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ruleset(
    @SerialName(value = "show-milliseconds") val showMilliseconds: Boolean,
    @SerialName(value = "require-verification") val requireVerification: Boolean,
    @SerialName(value = "require-video") val requireVideo: Boolean,
    @SerialName(value = "run-times") val runTimes: List<RunTimeEnum>,
    @SerialName(value = "default-time") val defaultTime: RunTimeEnum,
    @SerialName(value = "emulators-allowed") val emulatorsAllowed: Boolean
)
