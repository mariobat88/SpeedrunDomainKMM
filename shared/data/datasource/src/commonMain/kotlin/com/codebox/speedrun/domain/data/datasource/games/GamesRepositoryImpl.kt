package com.codebox.speedrun.domain.data.datasource.games

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.games.mapper.*
import com.codebox.speedrun.domain.data.datasource.platforms.mapper.toPlatformEntity
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.networking.api.games.GamesApiService
import kotlinx.coroutines.withContext

class GamesRepositoryImpl(
    private val gamesApiService: GamesApiService,
    private val dispatcherProvider: DispatcherProvider,
    database: Database,
) : GamesRepository {

    private val gameDao = database.gameDao()
    private val runTimeDao = database.runTimeDao()
    private val gameRunTimeDao = database.gameRunTimeDao()
    private val gameDeveloperDao = database.gameDeveloperDao()
    private val platformDao = database.platformDao()

    override suspend fun searchGames(
        name: String,
        offset: Int,
        max: Int
    ): PaginationModel<GameModel> = withContext(dispatcherProvider.io()) {
        val searchedGames = gamesApiService.searchGames(name = name, offset = offset, max = max)

        val runTimeEntities = searchedGames.data.map { it.ruleset.runTimes }
            .asSequence()
            .flatten()
            .distinctBy { it }
            .map { it.toRunTimeEntity() }
            .toList()


        val gameEntities = searchedGames.data.map { it.toEntity() }
        val gameNamesEntities = searchedGames.data.map { it.names.toEntity(it.id) }
        val gameRuleSetEntities = searchedGames.data.map { it.ruleset.toEntity(it.id) }
        val gameAssetsEntities = searchedGames.data.map { it.assets.toEntity(it.id) }
        val gameRunTimeEntities = searchedGames.data.map { it.toGameRunTimeEntity() }.flatten()
        val gameDeveloperEntities = searchedGames.data.map { it.toGameDeveloperEntity() }.flatten()
        val platformEntities = searchedGames.data.map { it.platforms.data.map { it.toPlatformEntity() } }.flatten()


        runTimeDao.upsertRunTimes(runTimeEntities)
        gameDao.upsertGames(gameEntities)
        gameDao.upsertGameNames(gameNamesEntities)
        gameDao.upsertGameRuleSet(gameRuleSetEntities)
        gameDao.upsertGameAssets(gameAssetsEntities)
        gameRunTimeDao.upsertGameRunTimes(gameRunTimeEntities)
        gameDeveloperDao.upsertGameDevelopers(gameDeveloperEntities)
        platformDao.upsertPlatforms(platformEntities)

        searchedGames.toModel()
    }
}
