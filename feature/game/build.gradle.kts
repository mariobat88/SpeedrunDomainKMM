plugins {
    id("speedrun.domain.android.feature")
}

dependencies{
    api(projects.shared.feature.game)
    implementation(projects.shared.data.common)
    implementation(libs.coil)
}
