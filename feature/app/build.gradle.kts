plugins {
    id("speedrun.domain.android.feature")
}

dependencies{
    api(projects.shared.feature.app)
    implementation(projects.feature.dashboard)
}
