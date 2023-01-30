package com.codebox.speedrun.domain.data.datasource.players.mapper

import com.codebox.speedrun.domain.data.database.PlayerEntity
import com.codebox.speedrun.domain.data.database.UserEntity
import com.codebox.speedrun.domain.data.database.UserNamesEntity
import com.codebox.speedrun.domain.data.database.UserNamesStyleEntity
import com.codebox.speedrun.domain.networking.api.players.models.NamesResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse

fun UserResponse.toPlayerEntity() = PlayerEntity(
    id = id,
    rel = "user",
)

fun UserResponse.toUserEntity() = UserEntity(
    id = id,
    weblink = weblink,
    role = role,
    signup = signup,
    location = location?.createLocationId(),
    twitch = twitch?.uri,
    hitbox = hitbox?.uri,
    youtube = youtube?.uri,
    twitter = twitter?.uri,
    speedrunslive = speedrunslive?.uri,
    icon = assets.icon?.uri,
    supporterIcon = assets.supporterIcon?.uri,
    image = assets.image?.uri,
)

fun NamesResponse.toUserNamesEntity(userId: String) = UserNamesEntity(
    userId = userId,
    international = international,
    japanese = japanese
)

fun UserResponse.NameStyle.toUserNamesStyleEntity(userId: String) = UserNamesStyleEntity(
    userId = userId,
    style = style,
    colorLight = color?.light,
    colorDark = color?.dark,
    colorFromLight = colorFrom?.light,
    colorFromDark = colorFrom?.dark,
    colorToLight = colorTo?.light,
    colorToDark = colorTo?.dark,
)
