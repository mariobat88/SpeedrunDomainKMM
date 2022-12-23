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
include(":shared")
include(":shared:core:base")
include(":shared:feature:test")
include(":shared:data:datasource")
include(":shared:data:repo")
include(":shared:di")
include(":shared:networking:api")
include(":core:annotations")
include(":core:designsystem")
include(":core:framework")
include(":core:initializer")
include(":feature:my-feature")