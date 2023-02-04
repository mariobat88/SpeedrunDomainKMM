package com.codebox.speedrun.domain.data.datasource.platforms.mapper

import com.codebox.speedrun.domain.data.database.PlatformEntity
import com.codebox.speedrun.domain.networking.api.platforms.models.PlatformResponse

fun PlatformResponse.toPlatformEntity() = PlatformEntity(
    platform_id = id,
    platform_name = name,
    platform_released = released.toLong(),
)