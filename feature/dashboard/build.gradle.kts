plugins {
    id("speedrun.domain.android.feature")
}

dependencies{
    api(projects.shared.feature.dashboard)
    implementation(libs.accompanist.placeholderMaterial)
    implementation(libs.coil)
}
