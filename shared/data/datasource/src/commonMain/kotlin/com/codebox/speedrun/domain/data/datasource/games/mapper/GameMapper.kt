package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.database.GameAssetsEntity
import com.codebox.speedrun.domain.data.database.GameEntity
import com.codebox.speedrun.domain.data.database.GameNamesEntity
import com.codebox.speedrun.domain.data.database.GameRuleSetEntity
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.networking.api.games.models.GameResponse
import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
import com.codebox.speedrun.domain.data.datasource.pagination.mapper.toModel
import com.codebox.speedrun.domain.data.datasource.common.mapper.toModel
import com.codebox.speedrun.domain.networking.api.games.models.Assets
import com.codebox.speedrun.domain.networking.api.games.models.Ruleset
import com.codebox.speedrun.domain.networking.api.players.models.NamesResponse

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

fun GameResponse.toEntity() = GameEntity(
    id = id,
    boostReceived = boostReceived.toLong(),
    boostDistinctDonors = boostDistinctDonors.toLong(),
    abbreviation = abbreviation,
    weblink = weblink,
    discord = discord,
    released = released.toLong(),
    releaseDate = releaseDate,
    romhack = romhack,
    created = created,
)

fun NamesResponse.toEntity(gameId: String) = GameNamesEntity(
    gameId = gameId,
    international = international,
    japanese = japanese,
    twitch = twitch,
)

fun Ruleset.toEntity(gameId: String) = GameRuleSetEntity(
    gameId = gameId,
    showMilliseconds = showMilliseconds,
    requireVerification = requireVerification,
    requireVideo = requireVideo,
    defaultTime = defaultTime,
    emulatorsAllowed = emulatorsAllowed,
)

fun Assets.toEntity(gameId: String) = GameAssetsEntity(
    gameId = gameId,
    logo = logo.uri,
    coverTiny = coverTiny.uri,
    coverSmall = coverSmall.uri,
    coverMedium = coverMedium.uri,
    coverLarge = coverLarge.uri,
    icon = icon.uri,
    trophy1st = trophy1st.uri,
    trophy2nd = trophy2nd.uri,
    trophy3rd = trophy3rd.uri,
    trophy4th = trophy4th.uri,
    background = background.uri,
    foreground = foreground.uri,
)
