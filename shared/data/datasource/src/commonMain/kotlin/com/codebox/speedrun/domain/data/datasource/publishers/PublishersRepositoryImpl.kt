package com.codebox.speedrun.domain.data.datasource.publishers

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.datasource.publishers.mapper.toPublisherEntity
import com.codebox.speedrun.domain.data.datasource.publishers.mapper.toPublisherModel
import com.codebox.speedrun.domain.data.repo.publishers.PublishersRepository
import com.codebox.speedrun.domain.data.repo.publishers.model.PublisherModel
import com.codebox.speedrun.domain.networking.api.publishers.PublishersApiService
import kotlinx.coroutines.withContext

class PublishersRepositoryImpl(
    private val publishersApiService: PublishersApiService,
    private val dispatcherProvider: DispatcherProvider,
    database: Database,
) : PublishersRepository {

    private val publisherDao = database.publisherDao()

    override suspend fun getPublisher(id: String): PublisherModel =
        withContext(dispatcherProvider.io()) {
            val developerResponse = publishersApiService.getPublisher(id)
            val publisherEntity = developerResponse.data.toPublisherEntity()

            publisherDao.upsertPublisher(publisherEntity)
            publisherEntity.toPublisherModel()
        }
}
