package com.codebox.speedrun.domain

class Greeting(private val platform: Platform) {

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }
}
