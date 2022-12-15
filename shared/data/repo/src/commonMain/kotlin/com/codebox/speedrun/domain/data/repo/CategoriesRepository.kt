package com.codebox.speedrun.domain.data.repo

interface CategoriesRepository {

    suspend fun refreshCategoriesByGame(gameId: String)
}
