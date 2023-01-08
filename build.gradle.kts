// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.com.squareup.sqldelight.gradle.plugin)
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.0-rc01").apply(false)
    id("com.android.library").version("7.4.0-rc01").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
