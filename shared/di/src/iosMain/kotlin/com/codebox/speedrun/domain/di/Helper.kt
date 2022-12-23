package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.Greeting
import com.codebox.speedrun.domain.MyViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class GreetingHelper : KoinComponent {
    private val greeting: Greeting by inject()
    fun greet(): String = greeting.greeting()
}

class PlatformHelper : KoinComponent {
    val platform: Platform by inject()
}

class MyViewModelHelper : KoinComponent {
    val myViewModel: MyViewModel by inject()
}


//private fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
//    appDeclaration()
//    modules(commonModule)
//}

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}
