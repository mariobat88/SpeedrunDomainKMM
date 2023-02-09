plugins {
    id("speedrun.domain.android.feature")
}

dependencies{
    api(projects.shared.feature.leaderboards)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pagerIndicators)
}
