package com.codebox.speedrun.domain.networking.api.runs.models

import com.codebox.speedrun.domain.networking.api.players.models.FlatPlayerResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlatRunResponse(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "weblink") val weblink: String,
    @SerialName(value = "game") val game: String,
    @SerialName(value = "level") val level: String?,
    @SerialName(value = "category") val category: String,
    @SerialName(value = "videos") val videos: VideosResponse?,
    @SerialName(value = "comment") val comment: String?,
    @SerialName(value = "status") val status: StatusResponse,
    @SerialName(value = "players") val players: List<FlatPlayerResponse>,
    @SerialName(value = "date") val date: String?,
    @SerialName(value = "submitted") val submitted: String?,
    @SerialName(value = "times") val times: TimesResponse,
    @SerialName(value = "system") val system: SystemResponse,
    @SerialName(value = "splits") val splits: List<String>?,
    @SerialName(value = "values") val values: Map<String, String>?,
)
