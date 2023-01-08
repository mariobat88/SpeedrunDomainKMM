package com.codebox.speedrun.domain.data.repo.categories

interface CategoriesRepository {

    suspend fun refreshCategoriesByGame(gameId: String)
}
