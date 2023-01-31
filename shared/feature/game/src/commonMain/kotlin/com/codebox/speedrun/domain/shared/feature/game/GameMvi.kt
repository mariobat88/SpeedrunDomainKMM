package com.codebox.speedrun.domain.shared.feature.game

import com.codebox.speedrun.domain.core.framework.async.Async
import com.codebox.speedrun.domain.core.framework.async.Uninitialized
import com.codebox.speedrun.domain.data.repo.developers.model.DeveloperModel
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.publishers.model.PublisherModel

sealed class Intent{
    object BackClicked : Intent()
    object LeaderboardsClicked : Intent()
}

data class ViewState(
    val gameAsync: Async<GameModel> = Uninitialized,
    val developersAsync: Async<List<DeveloperModel>?> = Uninitialized,
    val publishersAsync: Async<List<PublisherModel>?> = Uninitialized,
    val developers: String = "",
    val publishers: String = "",
)
