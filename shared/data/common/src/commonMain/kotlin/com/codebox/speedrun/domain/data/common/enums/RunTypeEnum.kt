package com.codebox.speedrun.domain.data.common.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RunTypeEnum {
    @SerialName("per-level") PER_LEVEL,
    @SerialName("per-game") PER_GAME,
    @SerialName("unknown") UNKNOWN;
}
