package com.codebox.speedrun.domain.data.repo.players.model

import com.codebox.speedrun.domain.data.repo.common.model.NamesModel
import com.speedrun.domain.repo.common.model.LinkModel

sealed class PlayerModel {
    data class UserModel(
        val id: String,
        val names: NamesModel,
        val weblink: String,
        val nameStyle: NameStyle,
        val role: String,
        val signup: String?,
        val location: Location?,
        val twitch: String?,
        val hitbox: String?,
        val youtube: String?,
        val twitter: String?,
        val speedrunslive: String?,
        val icon: String?,
        val supporterIcon: String?,
        val image: String?,
    ) : PlayerModel() {
        data class NameStyle(
            val style: String,
            val color: Color?,
            val colorFrom: Color?,
            val colorTo: Color?
        ) {
            data class Color(
                val light: String,
                val dark: String
            )
        }

        data class Location(
            val country: Country,
            val region: Region?
        ) {
            data class Country(
                val code: String,
                val international: String,
                val japanese: String?,
            )

            data class Region(
                val code: String,
                val international: String,
                val japanese: String?,
            )
        }

        data class Assets(
            val icon: Asset?,
            val supporterIcon: Asset?,
            val image: Asset?,
        ) {
            data class Asset(
                val uri: String?,
            )
        }
    }

    data class GuestModel(
        val name: String,
        val links: List<LinkModel>
    ) : PlayerModel()
}
