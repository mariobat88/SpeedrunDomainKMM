package com.codebox.speedrun.domain.data.datasource.players.mapper

import com.codebox.speedrun.domain.networking.api.players.models.UserResponse

fun UserResponse.Location.createLocationId() =
    "${country.code}${region?.code}"



