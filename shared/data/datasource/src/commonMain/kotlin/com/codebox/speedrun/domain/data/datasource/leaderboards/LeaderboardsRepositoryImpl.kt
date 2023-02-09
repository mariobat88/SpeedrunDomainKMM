package com.codebox.speedrun.domain.data.datasource.leaderboards

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.categories.mapper.toEntity
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.createId
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.toLeaderboardEntity
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.toLeaderboardRunEntity
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.toPlaceEntity
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.toRunValueEntities
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.toValueEntities
import com.codebox.speedrun.domain.data.datasource.leaderboards.mapper.toVariableEntity
import com.codebox.speedrun.domain.data.datasource.players.mapper.toGuestEntity
import com.codebox.speedrun.domain.data.datasource.players.mapper.toPlayerEntity
import com.codebox.speedrun.domain.data.datasource.players.mapper.toUserEntity
import com.codebox.speedrun.domain.data.datasource.runs.mapper.toRunEntity
import com.codebox.speedrun.domain.data.datasource.runs.mapper.toRunPlayerEntity
import com.codebox.speedrun.domain.data.datasource.runs.mapper.toRunStatusEntity
import com.codebox.speedrun.domain.data.datasource.runs.mapper.toRunSystemEntity
import com.codebox.speedrun.domain.data.datasource.runs.mapper.toRunTimesEntity
import com.codebox.speedrun.domain.data.repo.leaderboards.LeaderboardsRepository
import com.codebox.speedrun.domain.networking.api.leaderboards.LeaderboardsApiService
import com.codebox.speedrun.domain.networking.api.players.models.GuestResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse
import kotlinx.coroutines.withContext

class LeaderboardsRepositoryImpl (
    private val leaderboardsApiService: LeaderboardsApiService,
    private val dispatcherProvider: DispatcherProvider,
    database: Database,
) : LeaderboardsRepository {

    private val categoryDao = database.categoryDao()
    private val leaderboardDao = database.leaderboardDao()
    private val leaderboardRunDao = database.leaderboardRunDao()
    private val placeDao = database.placeDao()
    private val playerDao = database.playerDao()
    private val runDao = database.runDao()
    private val runPlayerDao = database.runPlayerDao()
    private val runValueDao = database.runValueDao()
    private val valueDao  = database.valueDao()
    private val variableDao  = database.variableDao()
    private val variableValueDao = database.variableValueDao()
    private val videoDao = database.videoDao()

    override suspend fun refreshLeaderboards(gameId: String, categoryId: String) = withContext(dispatcherProvider.io()) {
        val response = leaderboardsApiService.getLeaderboard(gameId, categoryId)

        val leaderboardEntity = response.data.toLeaderboardEntity()
        val placeEntities = response.data.runs.map { it.toPlaceEntity() }
        val leaderboardRunEntities = response.data.runs.map { it.toLeaderboardRunEntity(response.data.createId()) }
        val userPlayerEntities = response.data.players.data.filterIsInstance<UserResponse>().map { it.toPlayerEntity() }
        val guestPlayerEntities = response.data.players.data.filterIsInstance<GuestResponse>().map { it.toPlayerEntity() }
        val userEntities = response.data.players.data.filterIsInstance<UserResponse>().map { it.toUserEntity() }
        //TODO: I need to map all other User stuff, probably need to move all of that to a method
        val guestEntities = response.data.players.data.filterIsInstance<GuestResponse>().map { it.toGuestEntity() }
        val playerEntities = userPlayerEntities + guestPlayerEntities

        val runEntities = response.data.runs.map { it.run.toRunEntity() }
        val runStatusEntities = response.data.runs.map { it.run.toRunStatusEntity() }
        val runTimesEntities = response.data.runs.map { it.run.times.toRunTimesEntity(it.run.id) }
        val runSystemEntities = response.data.runs.map { it.run.system.toRunSystemEntity(it.run.id) }

        val runPlayerEntities = response.data.runs.map { leaderboardRun -> leaderboardRun.run.players.map { it.toRunPlayerEntity(leaderboardRun.run.id) } }.flatten()
        val runValueEntities = response.data.runs.mapNotNull { it.run.toRunValueEntities() }.flatten()
        val runCategoryEntity = response.data.category.data.toEntity(gameId)
        val runVideoEntities =  response.data.runs.mapNotNull { it.run.videos?.toEntity(it.run.id) }.flatten()
        val variableEntities = response.data.variables.data.map { it.toVariableEntity() }
        val valueEntities = response.data.variables.data.map { it.toValueEntities() }.flatten()
        val variableValueEntities = response.data.variables.data.map { it.toVariableValueEntity() }.flatten()

        categoryDao.upsertCategory(runCategoryEntity)
        leaderboardDao.upsertLeaderboard(leaderboardEntity)
        placeDao.upsertPlaces(placeEntities)
        runDao.upsertRuns(runEntities)
        runDao.upsertRunStatuses(runStatusEntities)
        runDao.upsertRunTimes(runTimesEntities)
        runDao.upsertRunSystems(runSystemEntities)
//        videoDao.upsert(runVideoEntities)
        playerDao.upsertPlayers(playerEntities)
        playerDao.upsertUsers(userEntities)
        playerDao.upsertGuests(guestEntities)

        leaderboardRunDao.upsertLeaderboardRuns(leaderboardRunEntities)
        runPlayerDao.upsertRunPlayers(runPlayerEntities)
        runValueDao.upsertRunValues(runValueEntities)
        valueDao.upsertValues(valueEntities)
        variableDao.upsertVariables(variableEntities)
//        variableValueDao.upsert(variableValueEntities)
    }
}
