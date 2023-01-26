package com.codebox.speedrun.domain.data.datasource.games

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.games.mapper.toEntity
import com.codebox.speedrun.domain.data.datasource.games.mapper.toModel
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
//    private val runTimeDao = speedrunDatabase.runTimeDao()
//    private val gameRunTimeDao = speedrunDatabase.gameRunTimeDao()
//    private val gameDeveloperDao = speedrunDatabase.gameDeveloperDao()
//    private val platformDao = speedrunDatabase.platformDao()

    override suspend fun searchGames(
        name: String,
        offset: Int,
        max: Int
    ): PaginationModel<GameModel> = withContext(dispatcherProvider.io()) {
        val searchedGames = gamesApiService.searchGames(name = name, offset = offset, max = max)

        val gameEntities = searchedGames.data.map { it.toEntity() }
        val gameNamesEntities = searchedGames.data.map { it.names.toEntity(it.id) }
        val gameRuleSetEntities = searchedGames.data.map { it.ruleset.toEntity(it.id) }
        val gameAssetsEntities = searchedGames.data.map { it.assets.toEntity(it.id) }

        gameDao.upsertGames(gameEntities)
        gameDao.upsertGameNames(gameNamesEntities)
        gameDao.upsertGameRuleSet(gameRuleSetEntities)
        gameDao.upsertGameAssets(gameAssetsEntities)

        searchedGames.toModel()
    }
}
