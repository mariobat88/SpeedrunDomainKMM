package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.GameAssetsEntity
import com.codebox.speedrun.domain.data.database.GameEntity
import com.codebox.speedrun.domain.data.database.GameNamesEntity
import com.codebox.speedrun.domain.data.database.GameRuleSetEntity
import com.codebox.speedrun.domain.data.database.GetGameById
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertGames(games: List<GameEntity>) {
        dbQuery.transaction {
            games.forEach {
                dbQuery.upsertGame(
                    game_id = it.game_id,
                    game_boostReceived = it.game_boostReceived,
                    game_boostDistinctDonors = it.game_boostDistinctDonors,
                    game_abbreviation = it.game_abbreviation,
                    game_weblink = it.game_weblink,
                    game_discord = it.game_discord,
                    game_released = it.game_released,
                    game_releaseDate = it.game_releaseDate,
                    game_romhack = it.game_romhack,
                    game_created = it.game_created,
                )
            }
        }
    }

    fun upsertGameNames(gameNames: List<GameNamesEntity>) {
        dbQuery.transaction {
            gameNames.forEach {
                dbQuery.upsertGameNames(
                    gameName_gameId = it.gameName_gameId,
                    gameName_international = it.gameName_international,
                    gameName_japanese = it.gameName_japanese,
                    gameName_twitch = it.gameName_twitch,
                )
            }
        }
    }

    fun upsertGameRuleSet(gameRuleSets: List<GameRuleSetEntity>) {
        dbQuery.transaction {
            gameRuleSets.forEach {
                dbQuery.upsertGameRuleSet(
                    gameRuleSet_gameId = it.gameRuleSet_gameId,
                    gameRuleSet_showMilliseconds = it.gameRuleSet_showMilliseconds,
                    gameRuleSet_requireVerification = it.gameRuleSet_requireVerification,
                    gameRuleSet_requireVideo = it.gameRuleSet_requireVideo,
                    gameRuleSet_defaultTime = it.gameRuleSet_defaultTime,
                    gameRuleSet_emulatorsAllowed = it.gameRuleSet_emulatorsAllowed,
                )
            }
        }
    }

    fun upsertGameAssets(gameAssets: List<GameAssetsEntity>) {
        dbQuery.transaction {
            gameAssets.forEach {
                dbQuery.upsertGameAssets(
                    gameAsset_gameId = it.gameAsset_gameId,
                    gameAsset_logo = it.gameAsset_logo,
                    gameAsset_coverTiny = it.gameAsset_coverTiny,
                    gameAsset_coverSmall = it.gameAsset_coverSmall,
                    gameAsset_coverMedium = it.gameAsset_coverMedium,
                    gameAsset_coverLarge = it.gameAsset_coverLarge,
                    gameAsset_icon = it.gameAsset_icon,
                    gameAsset_trophy1st = it.gameAsset_trophy1st,
                    gameAsset_trophy2nd = it.gameAsset_trophy2nd,
                    gameAsset_trophy3rd = it.gameAsset_trophy3rd,
                    gameAsset_trophy4th = it.gameAsset_trophy4th,
                    gameAsset_background = it.gameAsset_background,
                    gameAsset_foreground = it.gameAsset_foreground,
                )
            }
        }
    }

    fun getGameById(id: String): Flow<List<GetGameById>> {
        return dbQuery.getGameById(id).asFlow().map { it.executeAsList() }
    }
}
