package com.codebox.speedrun.domain.data.datasource.players

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.players.mapper.*
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

    private val categoryDao = database.categoryDao()
    private val playerDao = database.playerDao()
    private val locationDao = database.locationDao()
    private val userLocationDao = database.userLocationDao()
    override suspend fun refreshPlayer(playerId: String): Unit =
        withContext(dispatcherProvider.io()) {
            val response = playersApiService.getPlayer(playerId)
            val playerEntity = response.userResponse.toPlayerEntity()
            val userEntity = response.userResponse.toUserEntity()
            val userNameEntity = response.userResponse.names.toUserNamesEntity(playerId)
            val userNameStyleEntity = response.userResponse.nameStyle.toUserNamesStyleEntity(playerId)

            playerDao.upsertPlayer(playerEntity)
            playerDao.upsertUser(userEntity)
            playerDao.upsertUserName(userNameEntity)
            playerDao.upsertUserNameStyle(userNameStyleEntity)
        }

    override suspend fun searchPlayers(
        name: String,
        offset: Int,
        max: Int
    ): PaginationModel<PlayerModel.UserModel> = withContext(dispatcherProvider.io()) {

        val searchedPlayers = playersApiService.searchPlayers(name = name, offset = offset, max = max)

        val playerEntities = searchedPlayers.data.map { it.toPlayerEntity() }
        val userEntities = searchedPlayers.data.map { it.toUserEntity() }
        val userNameEntities = searchedPlayers.data.map { it.names.toUserNamesEntity(it.id) }
        val userNameStyleEntities = searchedPlayers.data.map { it.nameStyle.toUserNamesStyleEntity(it.id) }
        val locations = searchedPlayers.data.mapNotNull { it.location?.toLocationEntity() }
        val userLocations = searchedPlayers.data.mapNotNull { it.location?.toUserLocationEntity(it.id) }

        playerDao.upsertPlayers(playerEntities)
        playerDao.upsertUsers(userEntities)
        playerDao.upsertUserNames(userNameEntities)
        playerDao.upsertUserNameStyles(userNameStyleEntities)
        playerDao.upsertUserNameStyles(userNameStyleEntities)
        locationDao.upsertLocations(locations)
        userLocationDao.upsertUserLocations(userLocations)

        searchedPlayers.toPaginationModel()
    }
}