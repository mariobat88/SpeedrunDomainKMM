package com.codebox.speedrun.domain.networking.api.runs.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatusResponse(
    @SerialName(value = "status") val status: String,
    @SerialName(value = "examiner") val examiner: String?,
    @SerialName(value = "verify-date") val verifyDate: String?
)
