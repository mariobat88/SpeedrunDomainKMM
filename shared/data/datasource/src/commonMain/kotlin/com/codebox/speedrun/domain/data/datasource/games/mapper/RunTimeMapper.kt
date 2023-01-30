package com.codebox.speedrun.domain.data.datasource.games.mapper

import com.codebox.speedrun.domain.data.common.enums.RunTimeEnum
import com.codebox.speedrun.domain.data.database.RunTimeEntity

fun RunTimeEnum.toRunTimeEntity() = RunTimeEntity(
    runTime = this
)

fun RunTimeEntity.toRunTimeEnum() = this.runTime
