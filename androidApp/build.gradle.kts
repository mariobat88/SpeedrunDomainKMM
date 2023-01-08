import com.codebox.speedrun.domain.app

plugins {
    id("speedrun.domain.android.application.compose")
}

android {
    defaultConfig {
        applicationId = app.applicationId
        versionName = app.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "API_URL", "\"https://www.speedrun.com/api/v1/\"")
        }
        debug {
            isDebuggable = true

            buildConfigField("String", "API_URL", "\"https://www.speedrun.com/api/v1/\"")
        }
    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material3)

    implementation(projects.shared.di)
    implementation(projects.shared.data.database)
    implementation(projects.feature.app)
    implementation(projects.feature.dashboard)
//    implementation(projects.core.navigation)
//    implementation(projects.core.wrapper.logging)
//    implementation(projects.data.database)
//    implementation(projects.data.datasource)
//    implementation(projects.feature.dashboard)
//    implementation(projects.feature.game)
//    implementation(projects.feature.leaderboards)
//    implementation(projects.feature.player)
//    implementation(projects.feature.run)
//    implementation(projects.networking.core)
//
}
