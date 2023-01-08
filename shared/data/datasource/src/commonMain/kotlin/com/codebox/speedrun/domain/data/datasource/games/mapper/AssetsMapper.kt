package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.networking.api.games.models.Assets

fun Assets.toModel() = GameModel.Assets(
    logo = logo.uri,
    coverTiny = coverTiny.uri,
    coverSmall = coverSmall.uri,
    coverMedium = coverMedium.uri,
    coverLarge = coverLarge.uri,
    icon = icon.uri,
    trophy1st = trophy1st.uri,
    trophy2nd = trophy2nd.uri,
    trophy3rd = trophy3rd.uri,
    trophy4th = trophy4th.uri,
    background = background.uri,
    foreground = foreground.uri,
)