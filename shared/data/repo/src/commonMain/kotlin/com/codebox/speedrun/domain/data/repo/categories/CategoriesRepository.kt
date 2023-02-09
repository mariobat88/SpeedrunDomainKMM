package com.codebox.speedrun.domain.data.repo.categories

import com.codebox.speedrun.domain.data.repo.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    suspend fun refreshCategoriesByGame(gameId: String)

    suspend fun observeCategoriesByGame(gameId: String): Flow<List<CategoryModel>>
}
