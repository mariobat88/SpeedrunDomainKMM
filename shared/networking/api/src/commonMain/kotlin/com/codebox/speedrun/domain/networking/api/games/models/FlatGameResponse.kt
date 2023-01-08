package com.codebox.speedrun.domain.networking.api.games.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlatGameResponse(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "names") val names: Names,
    @SerialName(value = "boostReceived") val boostReceived: Int,
    @SerialName(value = "boostDistinctDonors") val boostDistinctDonors: Int,
    @SerialName(value = "abbreviation") val abbreviation: String,
    @SerialName(value = "weblink") val weblink: String,
    @SerialName(value = "discord") val discord: String?,
    @SerialName(value = "released") val released: Int,
    @SerialName(value = "release-date") val releaseDate: String,
    @SerialName(value = "ruleset") val ruleset: Ruleset,
    @SerialName(value = "romhack") val romhack: Boolean,
    @SerialName(value = "gametypes") val gametypes: List<String>,
    @SerialName(value = "platforms") val platforms: List<String>,
    @SerialName(value = "regions") val regions: List<String>,
    @SerialName(value = "genres") val genres: List<String>,
    @SerialName(value = "engines") val engines: List<String>,
    @SerialName(value = "developers") val developers: List<String>,
    @SerialName(value = "publishers") val publishers: List<String>,
    @SerialName(value = "moderators") val moderators: Map<String, String>,
    @SerialName(value = "created") val created: String?,
    @SerialName(value = "assets") val assets: Assets,
)
