package com.codebox.speedrun.domain.data.datasource.players.mapper

import com.codebox.speedrun.domain.data.datasource.common.mapper.toModel
import com.codebox.speedrun.domain.data.datasource.pagination.mapper.toModel
import com.codebox.speedrun.domain.data.repo.pagination.model.PaginationModel
import com.codebox.speedrun.domain.data.repo.players.model.PlayerModel
import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
import com.codebox.speedrun.domain.networking.api.players.models.GuestResponse
import com.codebox.speedrun.domain.networking.api.players.models.PlayerResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse

fun PlayerResponse.toPlayerModel(): PlayerModel {
    return if (rel == "user") {
        with(this as UserResponse) {
            this.toUserModel()
        }
    } else {
        with(this as GuestResponse) {
            this.toGuestModel()
        }
    }
}

fun PaginationResponse<UserResponse>.toPaginationModel() =
    PaginationModel(
        data = data.map { it.toUserModel() },
        pagination = pagination.toModel()
    )


fun UserResponse.toUserModel() = PlayerModel.UserModel(
    id = id,
    names = names.toModel(),
    weblink = weblink,
    nameStyle = nameStyle.toModel(),
    role = role,
    signup = signup,
    location = location?.toModel(),
    twitch = twitch?.uri,
    hitbox = hitbox?.uri,
    youtube = youtube?.uri,
    twitter = twitter?.uri,
    speedrunslive = speedrunslive?.uri,
    icon = assets.icon?.uri,
    supporterIcon = assets.supporterIcon?.uri,
    image = assets.image?.uri,
)

fun GuestResponse.toGuestModel() = PlayerModel.GuestModel(
    name = name,
    links = links.map { it.toModel() }
)

private fun UserResponse.NameStyle.toModel() =
    PlayerModel.UserModel.NameStyle(
        style = style,
        color = color?.toModel(),
        colorFrom = colorFrom?.toModel(),
        colorTo = colorTo?.toModel(),
    )

private fun UserResponse.NameStyle.Color.toModel() =
    PlayerModel.UserModel.NameStyle.Color(
        light = light,
        dark = dark
    )

private fun UserResponse.Location.toModel() =
    PlayerModel.UserModel.Location(
        country = country.toModel(),
        region = region?.toModel(),
    )

private fun UserResponse.Location.Country.toModel() =
    PlayerModel.UserModel.Location.Country(
        code = code,
        international = names.international,
        japanese = names.japanese,
    )

private fun UserResponse.Location.Region.toModel() =
    PlayerModel.UserModel.Location.Region(
        code = code,
        international = names.international,
        japanese = names.japanese,
    )

private fun UserResponse.Assets.toModel() = PlayerModel.UserModel.Assets(
    icon = icon?.toModel(),
    supporterIcon = supporterIcon?.toModel(),
    image = image?.toModel(),
)

private fun UserResponse.Assets.Asset.toModel() =
    PlayerModel.UserModel.Assets.Asset(
        uri = uri,
    )



