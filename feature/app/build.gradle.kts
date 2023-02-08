plugins {
    id("speedrun.domain.android.feature")
}

dependencies{
    api(projects.shared.feature.app)
    implementation(projects.feature.dashboard)
    implementation(projects.feature.game)
    implementation(projects.feature.leaderboards)
}
