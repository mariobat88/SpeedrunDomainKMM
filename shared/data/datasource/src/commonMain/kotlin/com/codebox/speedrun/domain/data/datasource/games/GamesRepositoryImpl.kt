package com.codebox.speedrun.domain.data.datasource.games

import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.games.mapper.toModel
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.networking.api.games.GamesApiService

class GamesRepositoryImpl(
    private val gamesApiService: GamesApiService,
    database: Database,
) : GamesRepository {

//    private val gameDao = speedrunDatabase.gameDao()
//    private val runTimeDao = speedrunDatabase.runTimeDao()
//    private val gameRunTimeDao = speedrunDatabase.gameRunTimeDao()
//    private val gameDeveloperDao = speedrunDatabase.gameDeveloperDao()
//    private val platformDao = speedrunDatabase.platformDao()

    override suspend fun searchGames(
        name: String,
        offset: Int,
        max: Int
    ): PaginationModel<GameModel> {
        val searchedGames = gamesApiService.searchGames(name = name, offset = offset, max = max)

        return searchedGames.toModel()
    }
}