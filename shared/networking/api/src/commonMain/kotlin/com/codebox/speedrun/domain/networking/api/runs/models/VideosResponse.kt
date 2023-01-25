package com.codebox.speedrun.domain.networking.api.runs.models

import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideosResponse(
    @SerialName(value = "links") val links: List<LinkResponse>
)
