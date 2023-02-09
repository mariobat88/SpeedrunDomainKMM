package com.codebox.speedrun.domain.data.datasource.runs.mapper

import com.codebox.speedrun.domain.data.database.RunEntity
import com.codebox.speedrun.domain.data.database.RunStatusEntity
import com.codebox.speedrun.domain.data.database.RunSystemEntity
import com.codebox.speedrun.domain.data.database.RunTimesEntity
import com.codebox.speedrun.domain.networking.api.runs.models.FlatRunResponse
import com.codebox.speedrun.domain.networking.api.runs.models.SystemResponse
import com.codebox.speedrun.domain.networking.api.runs.models.TimesResponse

fun FlatRunResponse.toRunEntity() = RunEntity(
    run_id = id,
    run_weblink = weblink,
    run_gameId = game,
    run_level = level,
    run_categoryId = category,
    run_comment = comment,
    run_date = date,
    run_submitted = submitted,
)

fun FlatRunResponse.toRunStatusEntity() = RunStatusEntity(
    runStatus_runId = id,
    runStatus_status = status.status,
    runStatus_examiner = status.examiner,
    runStatus_verifyDate = status.verifyDate,
)

fun TimesResponse.toRunTimesEntity(runId: String) = RunTimesEntity(
    runTimes_runId = runId,
    runTimes_primary = primary,
    runTimes_primaryT = primaryT.toDouble(),
    runTimes_realtime = realtime,
    runTimes_realtimeT = realtimeT.toDouble(),
    runTimes_realtimeNoLoads = realtimeNoLoads,
    runTimes_realtimeNoLoadsT = realtimeNoLoadsT.toDouble(),
    runTimes_ingame = ingame,
    runTimes_ingameT = ingameT.toDouble(),
)

fun SystemResponse.toRunSystemEntity(runId: String) = RunSystemEntity(
    runSystem_runId = runId,
    runSystem_platform = platform,
    runSystem_emulated = emulated,
    runSystem_region = region,
)
