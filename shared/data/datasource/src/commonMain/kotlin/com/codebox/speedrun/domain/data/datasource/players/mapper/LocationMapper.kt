package com.codebox.speedrun.domain.data.datasource.players.mapper

import com.codebox.speedrun.domain.data.database.LocationEntity
import com.codebox.speedrun.domain.data.database.UserLocationEntity
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse

fun UserResponse.Location.createLocationId() = "${country.code}${region?.code}"

fun UserResponse.Location.toLocationEntity() = LocationEntity(
    id = createLocationId(),
    countryCode = country.code,
    countryInternational = country.names.international,
    countryJapanese = country.names.japanese,
    regionCode = region?.code,
    regionInternational = region?.names?.international,
    regionJapanese = region?.names?.japanese,
)

fun UserResponse.Location.toUserLocationEntity(userId: String) = UserLocationEntity(
    userId = userId,
    locationId = createLocationId(),
)
