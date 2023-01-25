package com.codebox.speedrun.domain.networking.api.players.models

import com.codebox.speedrun.domain.networking.api.categories.models.CategoryDataResponse
import com.codebox.speedrun.domain.networking.api.games.models.FlatGameDataResponse
import com.codebox.speedrun.domain.networking.api.runs.models.FlatRunResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonalBestsDataListResponse(
    @SerialName(value ="data") val data: List<PersonalBestData>
) {
    @Serializable
    data class PersonalBestData(
        @SerialName(value = "place") val place: Int,
        @SerialName(value = "run") val run: FlatRunResponse,
        @SerialName(value = "game") val game: FlatGameDataResponse,
        @SerialName(value = "category") val category: CategoryDataResponse,
    )
}
