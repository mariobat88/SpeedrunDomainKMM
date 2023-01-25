package com.codebox.speedrun.domain.networking.api.players.models

import com.codebox.speedrun.domain.networking.api.common.LinkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed class PlayerResponse{
    @SerialName(value = "rel") abstract val rel: String?
}

@Serializable
@SerialName("user")
data class UserResponse(
    @SerialName(value = "rel")
    override val rel: String?,
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "names")
    val names: NamesResponse,
    @SerialName(value = "weblink")
    val weblink: String,
    @SerialName(value = "name-style")
    val nameStyle: NameStyle,
    @SerialName(value = "role")
    val role: String,
    @SerialName(value = "signup")
    val signup: String?,
    @SerialName(value = "location")
    val location: Location?,
    @SerialName(value = "twitch")
    val twitch: LinkResponse?,
    @SerialName(value = "hitbox")
    val hitbox: LinkResponse?,
    @SerialName(value = "youtube")
    val youtube: LinkResponse?,
    @SerialName(value = "twitter")
    val twitter: LinkResponse?,
    @SerialName(value = "speedrunslive")
    val speedrunslive: LinkResponse?,
    @SerialName(value = "assets")
    val assets: Assets,
    @SerialName(value = "links")
    val links: List<LinkResponse>
) : PlayerResponse() {

    @Serializable
    data class NameStyle(
        @SerialName(value = "style")
        val style: String,
        @SerialName(value = "color")
        val color: Color?,
        @SerialName(value = "color-from")
        val colorFrom: Color?,
        @SerialName(value = "color-to")
        val colorTo: Color?
    ) {
        @Serializable
        data class Color(
            @SerialName(value = "light")
            val light: String,
            @SerialName(value = "dark")
            val dark: String
        )
    }

    @Serializable
    data class Location(
        @SerialName(value = "country")
        val country: Country,
        @SerialName(value = "region")
        val region: Region?
    ) {
        @Serializable
        data class Country(
            @SerialName(value = "code")
            val code: String,
            @SerialName(value = "names")
            val names: NamesResponse
        )

        @Serializable
        data class Region(
            @SerialName(value = "code")
            val code: String,
            @SerialName(value = "names")
            val names: NamesResponse
        )
    }

    @Serializable
    data class Assets(
        @SerialName(value = "icon")
        val icon: Asset?,
        @SerialName(value = "supporterIcon")
        val supporterIcon: Asset?,
        @SerialName(value = "image")
        val image: Asset?,
    ) {

        @Serializable
        data class Asset(
            @SerialName(value = "uri")
            val uri: String?,
        )
    }
}

@Serializable
@SerialName("guest")
data class GuestResponse(
    @SerialName(value = "rel") override val rel: String?,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "links") val links: List<LinkResponse>
) : PlayerResponse()
