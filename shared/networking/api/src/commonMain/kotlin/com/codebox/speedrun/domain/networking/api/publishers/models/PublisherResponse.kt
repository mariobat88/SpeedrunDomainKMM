package com.codebox.speedrun.domain.networking.api.publishers.models

import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PublisherResponse(
    @SerialName(value = "data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName(value = "id")
        val id: String,
        @SerialName(value = "name")
        val name: String,
        @SerialName(value = "links")
        val links: List<LinkResponse>
    )
}
