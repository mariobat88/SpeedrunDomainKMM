plugins {
    id("org.jetbrains.kotlin.android")
    id("speedrun.domain.android.library.compose")
}

dependencies{
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
}
