package com.codebox.speedrun.domain.data.datasource.categories

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.categories.mapper.toCategoryModel
import com.codebox.speedrun.domain.data.datasource.categories.mapper.toEntity
import com.codebox.speedrun.domain.data.repo.categories.CategoriesRepository
import com.codebox.speedrun.domain.data.repo.model.CategoryModel
import com.codebox.speedrun.domain.networking.api.categories.CategoriesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CategoriesRepositoryImpl(
    private val categoriesApiService: CategoriesApiService,
    private val dispatcherProvider: DispatcherProvider,
    database: Database,
) : CategoriesRepository {

    private val categoryDao = database.categoryDao()

    override suspend fun refreshCategoriesByGame(gameId: String): Unit =
        withContext(dispatcherProvider.io()) {
            val response = categoriesApiService.getCategories(gameId)
            val categoryEntities = response.data.map { it.toEntity(gameId) }
            val categoryPlayerEntities = response.data.map { it.players.toEntity(it.id) }

            categoryDao.upsertCategories(categoryEntities)
            categoryDao.upsertCategoryPlayer(categoryPlayerEntities)
        }

    override suspend fun observeCategoriesByGame(gameId: String): Flow<List<CategoryModel>> =
        withContext(dispatcherProvider.io()) {
            categoryDao.observeCategoriesByGameId(gameId).map { rows ->
                rows.map { it.toCategoryModel() }
            }
        }
}
