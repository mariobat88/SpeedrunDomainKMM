package com.codebox.speedrun.domain.networking.api.categories.models

import com.codebox.speedrun.domain.data.common.enums.RunTypeEnum
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "weblink") val weblink: String,
    @SerialName(value = "type") val type: RunTypeEnum,
    @SerialName(value = "rules") val rules: String?,
    @SerialName(value = "players") val players: Players,
    @SerialName(value = "miscellaneous") val miscellaneous: Boolean,
//    @SerialName(value = "links")
//    val links: List<LinkResponse>
) {
    @Serializable
    data class Players(
        @SerialName(value = "type") val type: String,
        @SerialName(value = "value") val value: Int
    )
}
