package com.codebox.speedrun.domain.feature.test

import com.codebox.speedrun.domain.core.base.BaseViewModel
import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import kotlinx.coroutines.launch

class TestViewModel(
    private val categoriesRepository: CategoriesRepository,
) : BaseViewModel() {

    init {
        scope.launch {
            try {
                categoriesRepository.refreshCategoriesByGame("123")
                print("BATBAT")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun greet() : String{
        return "HElloooooo"
    }
}
