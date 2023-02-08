package com.codebox.speedrun.domain.shared.feature.app.navigation

import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardNavigator
import com.codebox.speedrun.domain.shared.feature.game.navigation.GameNavigator
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigator

interface AppNavigator : DashboardNavigator, GameNavigator, LeaderboardsNavigator