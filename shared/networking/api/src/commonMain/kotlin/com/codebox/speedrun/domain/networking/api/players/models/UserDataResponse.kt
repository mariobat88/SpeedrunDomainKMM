package com.codebox.speedrun.domain.networking.api.players.models

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
data class UserDataResponse(
    @Polymorphic val userResponse: UserResponse,
)
