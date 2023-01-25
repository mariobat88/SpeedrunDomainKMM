package com.codebox.speedrun.domain.data.datasource.players

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.players.mapper.toPaginationModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.data.repo.players.model.PlayerModel
import com.codebox.speedrun.domain.networking.api.players.PlayersApiService
import kotlinx.coroutines.withContext

class PlayersRepositoryImpl(
    private val playersApiService: PlayersApiService,
    private val dispatcherProvider: DispatcherProvider,
    database: Database,
) : PlayersRepository {

    override suspend fun searchPlayers(
        name: String,
        offset: Int,
        max: Int
    ): PaginationModel<PlayerModel.UserModel> = withContext(dispatcherProvider.io()) {

        val searchedPlayers = playersApiService.searchPlayers(name = name, offset = offset, max = max)
        searchedPlayers.toPaginationModel()
    }
}