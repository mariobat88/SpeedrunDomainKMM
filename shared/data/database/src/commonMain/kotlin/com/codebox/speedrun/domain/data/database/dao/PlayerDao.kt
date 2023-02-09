package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class PlayerDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertPlayer(player: PlayerEntity) {
        dbQuery.transaction {
            dbQuery.upsertPlayer(
                player_id = player.player_id,
                player_rel = player.player_rel,
            )
        }
    }

    fun upsertPlayers(players: List<PlayerEntity>) {
        dbQuery.transaction { players.forEach { upsertPlayer(it) } }
    }

    fun upsertUser(user: UserEntity) {
        dbQuery.transaction {
            dbQuery.upsertUser(
                user_id = user.user_id,
                user_weblink = user.user_weblink,
                user_role = user.user_role,
                user_signup = user.user_signup,
                user_location = user.user_location,
                user_twitch = user.user_twitch,
                user_hitbox = user.user_hitbox,
                user_youtube = user.user_youtube,
                user_twitter = user.user_twitter,
                user_speedrunslive = user.user_speedrunslive,
                user_icon = user.user_icon,
                user_supporterIcon = user.user_supporterIcon,
                user_image = user.user_image,
            )
        }
    }

    fun upsertUsers(users: List<UserEntity>) {
        dbQuery.transaction { users.forEach { upsertUser(it) } }
    }

    fun upsertUserName(userName: UserNamesEntity) {
        dbQuery.transaction {
            dbQuery.upsertUserNames(
                userName_userId = userName.userName_userId,
                userName_international = userName.userName_international,
                userName_japanese = userName.userName_japanese,
            )
        }
    }

    fun upsertUserNames(userNames: List<UserNamesEntity>) {
        dbQuery.transaction { userNames.forEach { upsertUserName(it) } }
    }

    fun upsertUserNameStyle(userNameStyle: UserNamesStyleEntity) {
        dbQuery.transaction {
            dbQuery.upsertUserNameStyles(
                userNameStyle_userId = userNameStyle.userNameStyle_userId,
                userNameStyle_style = userNameStyle.userNameStyle_style,
                userNameStyle_colorLight = userNameStyle.userNameStyle_colorLight,
                userNameStyle_colorDark = userNameStyle.userNameStyle_colorDark,
                userNameStyle_colorFromLight = userNameStyle.userNameStyle_colorFromLight,
                userNameStyle_colorFromDark = userNameStyle.userNameStyle_colorFromDark,
                userNameStyle_colorToLight = userNameStyle.userNameStyle_colorToLight,
                userNameStyle_colorToDark = userNameStyle.userNameStyle_colorToDark,
            )
        }
    }

    fun upsertUserNameStyles(userNameStyles: List<UserNamesStyleEntity>) {
        dbQuery.transaction { userNameStyles.forEach { upsertUserNameStyle(it) } }
    }

    fun upsertGuests(guests: List<GuestEntity>) {
        dbQuery.transaction {
            guests.forEach {
                dbQuery.upsertGuests(
                    guest_id = it.guest_id,
                    guest_name = it.guest_name,
                )
            }
        }
    }
}
