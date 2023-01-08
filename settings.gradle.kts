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
include(":core:annotations")
include(":core:designsystem")
include(":core:framework")
include(":core:initializer")
include(":core:paging")
include(":core:ui")
include(":feature:app")
include(":feature:dashboard")

include(":shared")
include(":shared:core:framework")
include(":shared:core:navigation")
include(":shared:feature:app")
include(":shared:feature:dashboard")
include(":shared:data:common")
include(":shared:data:database")
include(":shared:data:datasource")
include(":shared:data:repo")
include(":shared:di")
include(":shared:networking:api")