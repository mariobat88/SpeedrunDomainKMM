plugins {
    id("speedrun.domain.android.feature")
}

dependencies{
    api(projects.shared.feature.dashboard)
    implementation(projects.kit.player)
    implementation(libs.accompanist.placeholderMaterial)
    implementation(libs.coil)
}
