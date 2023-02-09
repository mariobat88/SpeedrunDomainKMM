package com.codebox.speedrun.domain.data.datasource.players.mapper

import com.codebox.speedrun.domain.data.database.GuestEntity
import com.codebox.speedrun.domain.data.database.PlayerEntity
import com.codebox.speedrun.domain.data.database.UserEntity
import com.codebox.speedrun.domain.data.database.UserNamesEntity
import com.codebox.speedrun.domain.data.database.UserNamesStyleEntity
import com.codebox.speedrun.domain.networking.api.players.models.GuestResponse
import com.codebox.speedrun.domain.networking.api.players.models.NamesResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse

fun UserResponse.toPlayerEntity() = PlayerEntity(
    player_id = id,
    player_rel = "user",
)

fun UserResponse.toUserEntity() = UserEntity(
    user_id = id,
    user_weblink = weblink,
    user_role = role,
    user_signup = signup,
    user_location = location?.createLocationId(),
    user_twitch = twitch?.uri,
    user_hitbox = hitbox?.uri,
    user_youtube = youtube?.uri,
    user_twitter = twitter?.uri,
    user_speedrunslive = speedrunslive?.uri,
    user_icon = assets.icon?.uri,
    user_supporterIcon = assets.supporterIcon?.uri,
    user_image = assets.image?.uri,
)

fun NamesResponse.toUserNamesEntity(userId: String) = UserNamesEntity(
    userName_userId = userId,
    userName_international = international,
    userName_japanese = japanese
)

fun UserResponse.NameStyle.toUserNamesStyleEntity(userId: String) = UserNamesStyleEntity(
    userNameStyle_userId = userId,
    userNameStyle_style = style,
    userNameStyle_colorLight = color?.light,
    userNameStyle_colorDark = color?.dark,
    userNameStyle_colorFromLight = colorFrom?.light,
    userNameStyle_colorFromDark = colorFrom?.dark,
    userNameStyle_colorToLight = colorTo?.light,
    userNameStyle_colorToDark = colorTo?.dark,
)

fun GuestResponse.toPlayerEntity() = PlayerEntity(
    player_id = name,
    player_rel = "guest",
)

fun GuestResponse.toGuestEntity() = GuestEntity(
    guest_id = name,
    guest_name = name,
)