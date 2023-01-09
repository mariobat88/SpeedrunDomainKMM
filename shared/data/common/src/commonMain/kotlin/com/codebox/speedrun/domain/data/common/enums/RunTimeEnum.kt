package com.codebox.speedrun.domain.data.common.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RunTimeEnum {
    @SerialName("realtime") REALTIME,
    @SerialName("realtime_noloads") REALTIME_NOLOADS,
    @SerialName("ingame") INGAME,
    @SerialName("unknown") UNKNOWN;
}
