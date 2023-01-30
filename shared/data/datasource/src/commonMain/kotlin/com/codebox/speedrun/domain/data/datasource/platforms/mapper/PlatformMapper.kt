package com.codebox.speedrun.domain.data.datasource.platforms.mapper

import com.codebox.speedrun.domain.data.database.PlatformEntity
import com.codebox.speedrun.domain.networking.api.platforms.models.PlatformResponse

fun PlatformResponse.toPlatformEntity() = PlatformEntity(
    id = id,
    name = name,
    released = released.toLong(),
)