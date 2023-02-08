package com.codebox.speedrun.domain.shared.feature.leaderboards

import com.codebox.speedrun.domain.core.framework.async.Async
import com.codebox.speedrun.domain.core.framework.async.Uninitialized
import com.codebox.speedrun.domain.data.repo.leaderboards.model.LeaderboardModel
import com.codebox.speedrun.domain.data.repo.model.CategoryModel

sealed class Intent {
    data class CategorySelected(val index: Int) : Intent()
    data class RunClicked(val runId: String?) : Intent()
}

data class ViewState(
    val categoriesAsync: Async<List<CategoryModel>> = Uninitialized,
    val leaderboardsMap: MutableMap<Int, Async<LeaderboardModel>> = mutableMapOf()
)
