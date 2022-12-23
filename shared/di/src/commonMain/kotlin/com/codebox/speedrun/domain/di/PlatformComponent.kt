package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.Platform

class PlatformComponent : AppComponent {

    //Singleton
    val platform by lazy{ Platform() }
}
