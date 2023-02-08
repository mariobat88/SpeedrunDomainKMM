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
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.splashscreen)

    implementation(projects.shared.di)
    implementation(projects.shared.data.database)
    implementation(projects.feature.app)
}
