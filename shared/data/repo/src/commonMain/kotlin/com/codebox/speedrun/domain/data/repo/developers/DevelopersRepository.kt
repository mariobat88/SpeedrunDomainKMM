package com.codebox.speedrun.domain.data.repo.developers

import com.codebox.speedrun.domain.data.repo.developers.model.DeveloperModel

interface DevelopersRepository {

    suspend fun getDeveloper(id: String): DeveloperModel
}
