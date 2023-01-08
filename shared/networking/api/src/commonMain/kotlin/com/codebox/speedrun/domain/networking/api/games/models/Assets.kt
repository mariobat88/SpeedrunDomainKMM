package com.codebox.speedrun.domain.networking.api.games.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Assets(
    @SerialName(value = "logo") val logo: Asset,
    @SerialName(value = "cover-tiny") val coverTiny: Asset,
    @SerialName(value = "cover-small") val coverSmall: Asset,
    @SerialName(value = "cover-medium") val coverMedium: Asset,
    @SerialName(value = "cover-large") val coverLarge: Asset,
    @SerialName(value = "icon") val icon: Asset,
    @SerialName(value = "trophy-1st") val trophy1st: Asset,
    @SerialName(value = "trophy-2nd") val trophy2nd: Asset,
    @SerialName(value = "trophy-3rd") val trophy3rd: Asset,
    @SerialName(value = "trophy-4th") val trophy4th: Asset,
    @SerialName(value = "background") val background: Asset,
    @SerialName(value = "foreground") val foreground: Asset
) {
    @Serializable
    data class Asset(
        @SerialName(value = "uri") val uri: String?
    )
}
