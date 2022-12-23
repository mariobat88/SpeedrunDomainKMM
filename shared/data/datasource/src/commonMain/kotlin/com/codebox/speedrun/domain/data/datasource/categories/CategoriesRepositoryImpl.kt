package com.codebox.speedrun.domain.data.datasource.categories

import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import com.codebox.speedrun.domain.networking.api.categories.CategoriesApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriesRepositoryImpl(
    private val categoriesApiService: CategoriesApiService,
) : CategoriesRepository {

    //TODO: Inject and change dispatchers
    override suspend fun refreshCategoriesByGame(gameId: String) = withContext(Dispatchers.Default) {
        val categories = categoriesApiService.getCategories("nxd1rk8q")
        Unit
    }
}
