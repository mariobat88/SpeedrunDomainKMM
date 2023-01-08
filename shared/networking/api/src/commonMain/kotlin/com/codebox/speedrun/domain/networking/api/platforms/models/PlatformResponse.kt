package com.codebox.speedrun.domain.networking.api.platforms.models

import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformResponse(
     @SerialName(value = "id") val id: String,
     @SerialName(value = "name") val name: String,
     @SerialName(value = "released") val released: Int,
     @SerialName(value = "links") val links: List<LinkResponse>
)
