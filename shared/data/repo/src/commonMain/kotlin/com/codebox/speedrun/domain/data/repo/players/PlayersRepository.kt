package com.codebox.speedrun.domain.data.repo.players

import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.data.repo.players.model.PlayerModel

interface PlayersRepository {
//    suspend fun refreshPlayer(playerId:String)
//    suspend fun refreshUserPersonalBests(playerId:String)
    suspend fun searchPlayers(name: String, offset: Int, max: Int): PaginationModel<PlayerModel.UserModel>
//    suspend fun observePlayer(playerId:String): Flow<PlayerModel?>
//    suspend fun observePlayerPersonalBests(playerId:String): Flow<List<RunPositionModel>>
}
