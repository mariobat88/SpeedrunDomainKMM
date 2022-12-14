plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("javaLibrary") {
            id = "speedrun.domain.java.library"
            implementationClass = "base.JavaLibraryConventionPlugin"
        }
        register("androidLibrary") {
            id = "speedrun.domain.android.library"
            implementationClass = "android.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "speedrun.domain.android.library.compose"
            implementationClass = "android.AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "speedrun.domain.android.application"
            implementationClass = "android.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "speedrun.domain.android.application.compose"
            implementationClass = "android.AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "speedrun.domain.android.hilt"
            implementationClass = "android.AndroidHiltConventionPlugin"
        }
        register("speedrunDomainFeature") {
            id = "speedrun.domain.android.feature"
            implementationClass = "android.SpeedrunDomainFeatureConventionPlugin"
        }
        register("speedrunDomainApi") {
            id = "speedrun.domain.android.api"
            implementationClass = "android.SpeedrunDomainApiConventionPlugin"
        }
        register("speedrunDomainRepo") {
            id = "speedrun.domain.android.repo"
            implementationClass = "android.SpeedrunDomainRepoConventionPlugin"
        }
        register("speedrunDomainDatasource") {
            id = "speedrun.domain.android.datasource"
            implementationClass = "android.SpeedrunDomainDatasourceConventionPlugin"
        }
        register("kmmLibrary") {
            id = "kmm.library"
            implementationClass = "kmm.KmmLibraryConventionPlugin"
        }
    }
}
