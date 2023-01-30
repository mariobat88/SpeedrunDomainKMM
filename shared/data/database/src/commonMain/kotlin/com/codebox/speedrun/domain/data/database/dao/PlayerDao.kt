package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class PlayerDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertPlayer(player: PlayerEntity) {
        dbQuery.transaction {
            dbQuery.upsertPlayer(
                id = player.id,
                rel = player.rel,
            )
        }
    }

    fun upsertPlayers(players: List<PlayerEntity>) {
        dbQuery.transaction {
            players.forEach {
                dbQuery.upsertPlayer(
                    id = it.id,
                    rel = it.rel,
                )
            }
        }
    }

    fun upsertUser(user: UserEntity) {
        dbQuery.transaction {
            dbQuery.upsertUser(
                id = user.id,
                weblink = user.weblink,
                role = user.role,
                signup = user.signup,
                location = user.location,
                twitch = user.twitch,
                hitbox = user.hitbox,
                youtube = user.youtube,
                twitter = user.twitter,
                speedrunslive = user.speedrunslive,
                icon = user.icon,
                supporterIcon = user.supporterIcon,
                image = user.image,
            )
        }
    }

    fun upsertUsers(users: List<UserEntity>) {
        dbQuery.transaction {
            users.forEach {
                dbQuery.upsertUser(
                    id = it.id,
                    weblink = it.weblink,
                    role = it.role,
                    signup = it.signup,
                    location = it.location,
                    twitch = it.twitch,
                    hitbox = it.hitbox,
                    youtube = it.youtube,
                    twitter = it.twitter,
                    speedrunslive = it.speedrunslive,
                    icon = it.icon,
                    supporterIcon = it.supporterIcon,
                    image = it.image,
                )
            }
        }
    }

    fun upsertUserName(userName: UserNamesEntity) {
        dbQuery.transaction {
            dbQuery.upsertUserNames(
                userId = userName.userId,
                international = userName.international,
                japanese = userName.japanese,
            )
        }
    }

    fun upsertUserNames(userNames: List<UserNamesEntity>) {
        dbQuery.transaction {
            userNames.forEach {
                dbQuery.upsertUserNames(
                    userId = it.userId,
                    international = it.international,
                    japanese = it.japanese,
                )
            }
        }
    }

    fun upsertUserNameStyle(userNameStyle: UserNamesStyleEntity) {
        dbQuery.transaction {
            dbQuery.upsertUserNameStyles(
                userId = userNameStyle.userId,
                style = userNameStyle.style,
                colorLight = userNameStyle.colorLight,
                colorDark = userNameStyle.colorDark,
                colorFromLight = userNameStyle.colorFromLight,
                colorFromDark = userNameStyle.colorFromDark,
                colorToLight = userNameStyle.colorToLight,
                colorToDark = userNameStyle.colorToDark,
            )
        }
    }

    fun upsertUserNameStyles(userNameStyles: List<UserNamesStyleEntity>) {
        dbQuery.transaction {
            userNameStyles.forEach {
                dbQuery.upsertUserNameStyles(
                    userId = it.userId,
                    style = it.style,
                    colorLight = it.colorLight,
                    colorDark = it.colorDark,
                    colorFromLight = it.colorFromLight,
                    colorFromDark = it.colorFromDark,
                    colorToLight = it.colorToLight,
                    colorToDark = it.colorToDark,
                )
            }
        }
    }

    fun upsertGuests(guests: List<GuestEntity>) {
        dbQuery.transaction {
            guests.forEach {
                dbQuery.upsertGuests(
                    id = it.id,
                    name = it.name,
                )
            }
        }
    }
}
