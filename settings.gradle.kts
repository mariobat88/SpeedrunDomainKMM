@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()

    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SpeedrunDomain"
include(":androidApp")
include(":di")
include(":shared")
include(":shared:core:framework")
include(":shared:data:datasource")
include(":shared:data:repo")
include(":shared:networking:api")
include(":core:annotations")
include(":core:designsystem")
include(":core:framework")
include(":core:initializer")