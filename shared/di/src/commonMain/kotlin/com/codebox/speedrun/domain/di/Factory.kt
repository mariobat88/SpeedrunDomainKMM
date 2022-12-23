package com.codebox.speedrun.domain.di

interface Factory<T> {
    fun create(): T
}
