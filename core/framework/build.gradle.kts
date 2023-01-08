plugins {
    id("org.jetbrains.kotlin.android")
    id("speedrun.domain.android.library.compose")
}

dependencies{
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.compose.runtime)
    implementation(libs.androidx.navigation.compose)
    api(projects.shared.core.framework)
}
