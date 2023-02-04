package com.codebox.speedrun.domain.data.database.result

import com.codebox.speedrun.domain.data.database.GameAssetsEntity
import com.codebox.speedrun.domain.data.database.GameDeveloperEntity
import com.codebox.speedrun.domain.data.database.GameEntity
import com.codebox.speedrun.domain.data.database.GameNamesEntity
import com.codebox.speedrun.domain.data.database.GamePublisherEntity
import com.codebox.speedrun.domain.data.database.GameRuleSetEntity
import com.codebox.speedrun.domain.data.database.RunTimeEntity

class GameResult(
    val gameEntity: GameEntity,
    val gameNamesEntity: GameNamesEntity,
    val gameRuleSetEntity: GameRuleSetEntity,
    val gameAssetsEntity: GameAssetsEntity,
    val runTimeEntities: List<RunTimeEntity>,
    val developers: List<GameDeveloperEntity> = emptyList(),
    val publishers: List<GamePublisherEntity> = emptyList(),
)