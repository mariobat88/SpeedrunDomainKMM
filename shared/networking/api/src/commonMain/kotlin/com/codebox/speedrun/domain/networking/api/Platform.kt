package com.codebox.speedrun.domain.networking.api

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform