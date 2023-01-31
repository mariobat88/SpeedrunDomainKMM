package com.codebox.speedrun.domain.data.repo.publishers

import com.codebox.speedrun.domain.data.repo.publishers.model.PublisherModel

interface PublishersRepository {

    suspend fun getPublisher(id: String): PublisherModel
}
