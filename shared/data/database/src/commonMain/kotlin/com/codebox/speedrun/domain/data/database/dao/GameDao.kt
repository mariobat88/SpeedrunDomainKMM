package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class GameDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertGames(games: List<GameEntity>) {
        dbQuery.transaction {
            games.forEach {
                dbQuery.upsertGame(
                    id = it.id,
                    boostReceived = it.boostReceived,
                    boostDistinctDonors = it.boostDistinctDonors,
                    abbreviation = it.abbreviation,
                    weblink = it.weblink,
                    discord = it.discord,
                    released = it.released,
                    releaseDate = it.releaseDate,
                    romhack = it.romhack,
                    created = it.created,
                )
            }
        }
    }

    fun upsertGameNames(gameNames: List<GameNamesEntity>) {
        dbQuery.transaction {
            gameNames.forEach {
                dbQuery.upsertGameNames(
                    gameId = it.gameId,
                    international = it.international,
                    japanese = it.japanese,
                    twitch = it.twitch,
                )
            }
        }
    }

    fun upsertGameRuleSet(gameRuleSets: List<GameRuleSetEntity>) {
        dbQuery.transaction {
            gameRuleSets.forEach {
                dbQuery.upsertGameRuleSet(
                    gameId = it.gameId,
                    showMilliseconds = it.showMilliseconds,
                    requireVerification = it.requireVerification,
                    requireVideo = it.requireVideo,
                    defaultTime = it.defaultTime,
                    emulatorsAllowed = it.emulatorsAllowed,
                )
            }
        }
    }

    fun upsertGameAssets(gameAssets: List<GameAssetsEntity>) {
        dbQuery.transaction {
            gameAssets.forEach {
                dbQuery.upsertGameAssets(
                    gameId = it.gameId,
                    logo = it.logo,
                    coverTiny = it.coverTiny,
                    coverSmall = it.coverSmall,
                    coverMedium = it.coverMedium,
                    coverLarge = it.coverLarge,
                    icon = it.icon,
                    trophy1st = it.trophy1st,
                    trophy2nd = it.trophy2nd,
                    trophy3rd = it.trophy3rd,
                    trophy4th = it.trophy4th,
                    background = it.background,
                    foreground = it.foreground,
                )
            }
        }
    }
}
