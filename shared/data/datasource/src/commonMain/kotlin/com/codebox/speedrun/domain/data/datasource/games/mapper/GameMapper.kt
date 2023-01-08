package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.networking.api.games.models.GameResponse
import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
import com.codebox.speedrun.domain.data.datasource.pagination.mapper.toModel
import com.codebox.speedrun.domain.data.datasource.games.mapper.toModel

fun PaginationResponse<GameResponse>.toModel() = PaginationModel(
    data = data.map { it.toModel() },
    pagination = pagination.toModel()
)

fun GameResponse.toModel() = GameModel(
    id = id,
    names = names.toModel(),
    boostReceived = boostReceived,
    boostDistinctDonors = boostDistinctDonors,
    abbreviation = abbreviation,
    weblink = weblink,
    discord = discord,
    released = released,
    releaseDate = releaseDate,
    ruleset = ruleset.toModel(),
    romhack = romhack,
    gametypes = gametypes,
    //platforms = platforms,
    platforms = emptyList(),
    regions = regions,
    genres = genres,
    engines = engines,
    developers = developers,
    publishers = publishers,
    moderators = moderators,
    created = created,
    assets = assets.toModel(),
)