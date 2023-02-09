package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.common.enums.RunTimeEnum
import com.codebox.speedrun.domain.data.database.GameAssetsEntity
import com.codebox.speedrun.domain.data.database.GameEntity
import com.codebox.speedrun.domain.data.database.GameNamesEntity
import com.codebox.speedrun.domain.data.database.GameRuleSetEntity
import com.codebox.speedrun.domain.data.database.GetGameById
import com.codebox.speedrun.domain.data.datasource.common.mapper.toModel
import com.codebox.speedrun.domain.data.datasource.pagination.mapper.toModel
import com.codebox.speedrun.domain.data.repo.common.model.NamesModel
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.networking.api.games.models.Assets
import com.codebox.speedrun.domain.networking.api.games.models.GameResponse
import com.codebox.speedrun.domain.networking.api.games.models.Ruleset
import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
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
    game_id = id,
    game_boostReceived = boostReceived.toLong(),
    game_boostDistinctDonors = boostDistinctDonors.toLong(),
    game_abbreviation = abbreviation,
    game_weblink = weblink,
    game_discord = discord,
    game_released = released.toLong(),
    game_releaseDate = releaseDate,
    game_romhack = romhack,
    game_created = created,
)

fun NamesResponse.toEntity(gameId: String) = GameNamesEntity(
    gameName_gameId = gameId,
    gameName_international = international,
    gameName_japanese = japanese,
    gameName_twitch = twitch,
)

fun Ruleset.toEntity(gameId: String) = GameRuleSetEntity(
    gameRuleSet_gameId = gameId,
    gameRuleSet_showMilliseconds = showMilliseconds,
    gameRuleSet_requireVerification = requireVerification,
    gameRuleSet_requireVideo = requireVideo,
    gameRuleSet_defaultTime = defaultTime,
    gameRuleSet_emulatorsAllowed = emulatorsAllowed,
)

fun Assets.toEntity(gameId: String) = GameAssetsEntity(
    gameAsset_gameId = gameId,
    gameAsset_logo = logo.uri,
    gameAsset_coverTiny = coverTiny.uri,
    gameAsset_coverSmall = coverSmall.uri,
    gameAsset_coverMedium = coverMedium.uri,
    gameAsset_coverLarge = coverLarge.uri,
    gameAsset_icon = icon.uri,
    gameAsset_trophy1st = trophy1st.uri,
    gameAsset_trophy2nd = trophy2nd.uri,
    gameAsset_trophy3rd = trophy3rd.uri,
    gameAsset_trophy4th = trophy4th.uri,
    gameAsset_background = background.uri,
    gameAsset_foreground = foreground.uri,
)

fun List<GetGameById>.toGameModel(): GameModel {
    val row = this[0]
    return GameModel(
        id = row.game_id,
        names = row.toNames(),
        boostReceived = row.game_boostReceived.toInt(),
        boostDistinctDonors = row.game_boostDistinctDonors.toInt(),
        abbreviation = row.game_abbreviation,
        weblink = row.game_weblink,
        discord = row.game_discord,
        released = row.game_released.toInt(),
        releaseDate = row.game_releaseDate,
        ruleset = row.toGameRuleSet(this.map { it.runTime }),
        romhack = row.game_romhack,
        gametypes = emptyList(),
        platforms = emptyList(),
        regions = emptyList(),
        genres = emptyList(),
        engines = emptyList(),
        developers = this.groupBy { it.gameId }.mapNotNull { row.developer_name },
        publishers = this.groupBy { it.gameId }.mapNotNull { row.publisher_name },
        moderators = emptyMap(),
        created = row.game_created,
        assets = row.toAssets(),
    )
}

private fun GetGameById.toNames() = NamesModel(
    international = gameName_international,
    japanese = gameName_international,
    twitch = gameName_twitch,
)

private fun GetGameById.toGameRuleSet(
    runTimes: List<RunTimeEnum>?,
) = GameModel.Ruleset(
    showMilliseconds = gameRuleSet_showMilliseconds,
    requireVerification = gameRuleSet_requireVerification,
    requireVideo = gameRuleSet_requireVideo,
    runTimes = runTimes,
    defaultTime = gameRuleSet_defaultTime,
    emulatorsAllowed = gameRuleSet_emulatorsAllowed,
)

private fun GetGameById.toAssets() = GameModel.Assets(
    logo = gameAsset_logo,
    coverTiny = gameAsset_coverTiny,
    coverSmall = gameAsset_coverSmall,
    coverMedium = gameAsset_coverMedium,
    coverLarge = gameAsset_coverLarge,
    icon = gameAsset_icon,
    trophy1st = gameAsset_trophy1st,
    trophy2nd = gameAsset_trophy2nd,
    trophy3rd = gameAsset_trophy3rd,
    trophy4th = gameAsset_trophy4th,
    background = gameAsset_background,
    foreground = gameAsset_foreground,
)