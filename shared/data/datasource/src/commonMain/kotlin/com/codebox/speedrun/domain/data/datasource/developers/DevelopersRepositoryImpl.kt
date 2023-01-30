package com.codebox.speedrun.domain.data.datasource.developers

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.developers.mapper.toDeveloperEntity
import com.codebox.speedrun.domain.data.datasource.developers.mapper.toDeveloperModel
import com.codebox.speedrun.domain.data.repo.developers.DevelopersRepository
import com.codebox.speedrun.domain.data.repo.developers.model.DeveloperModel
import com.codebox.speedrun.domain.networking.api.developers.DevelopersApiService
import kotlinx.coroutines.withContext

class DevelopersRepositoryImpl(
    private val developersApiService: DevelopersApiService,
    private val dispatcherProvider: DispatcherProvider,
    database: Database,
) : DevelopersRepository {

    private val developerDao = database.developerDao()

    override suspend fun getDeveloper(id: String): DeveloperModel =
        withContext(dispatcherProvider.io()) {
            withContext(dispatcherProvider.io()) {
                val developerResponse = developersApiService.getDeveloper(id)
                val developerEntity = developerResponse.data.toDeveloperEntity()

                developerDao.upsertDeveloper(developerEntity)
                developerEntity.toDeveloperModel()
            }
        }
}
