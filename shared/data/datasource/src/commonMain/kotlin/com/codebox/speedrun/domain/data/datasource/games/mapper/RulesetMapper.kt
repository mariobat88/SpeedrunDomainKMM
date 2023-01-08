package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.networking.api.games.models.Ruleset

fun Ruleset.toModel() = GameModel.Ruleset(
    showMilliseconds = showMilliseconds,
    requireVerification = requireVerification,
    requireVideo = requireVideo,
    runTimes = runTimes,
    defaultTime = defaultTime,
    emulatorsAllowed = emulatorsAllowed,
)
