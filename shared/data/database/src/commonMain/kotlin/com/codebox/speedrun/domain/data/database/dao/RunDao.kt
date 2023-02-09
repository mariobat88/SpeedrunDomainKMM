package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.RunEntity
import com.codebox.speedrun.domain.data.database.RunStatusEntity
import com.codebox.speedrun.domain.data.database.RunSystemEntity
import com.codebox.speedrun.domain.data.database.RunTimesEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class RunDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    private fun upsertRun(run: RunEntity) {
        dbQuery.transaction {
            dbQuery.upsertRun(
                run_id = run.run_id,
                run_weblink = run.run_weblink,
                run_gameId = run.run_gameId,
                run_level = run.run_level,
                run_categoryId = run.run_categoryId,
                run_comment = run.run_comment,
                run_date = run.run_date,
                run_submitted = run.run_submitted,
            )
        }
    }

    fun upsertRuns(runs: List<RunEntity>) {
        dbQuery.transaction { runs.forEach { upsertRun(it) } }
    }

    private fun upsertRunStatus(runStatus: RunStatusEntity) {
        dbQuery.transaction {
            dbQuery.upsertRunStatus(
                runStatus_runId = runStatus.runStatus_runId,
                runStatus_status = runStatus.runStatus_status,
                runStatus_examiner = runStatus.runStatus_examiner,
                runStatus_verifyDate = runStatus.runStatus_verifyDate,
            )
        }
    }

    fun upsertRunStatuses(runs: List<RunStatusEntity>) {
        dbQuery.transaction { runs.forEach { upsertRunStatus(it) } }
    }

    private fun upsertRunTime(runTime: RunTimesEntity) {
        dbQuery.transaction {
            dbQuery.upsertRunTimes(
                runTimes_runId = runTime.runTimes_runId,
                runTimes_primary = runTime.runTimes_primary,
                runTimes_primaryT = runTime.runTimes_primaryT,
                runTimes_realtime = runTime.runTimes_realtime,
                runTimes_realtimeT = runTime.runTimes_realtimeT,
                runTimes_realtimeNoLoads = runTime.runTimes_realtimeNoLoads,
                runTimes_realtimeNoLoadsT = runTime.runTimes_realtimeNoLoadsT,
                runTimes_ingame = runTime.runTimes_ingame,
                runTimes_ingameT = runTime.runTimes_ingameT,
            )
        }
    }

    fun upsertRunTimes(runTimes: List<RunTimesEntity>) {
        dbQuery.transaction { runTimes.forEach { upsertRunTime(it) } }
    }

    private fun upsertRunSystem(runSystem: RunSystemEntity) {
        dbQuery.transaction {
            dbQuery.upsertRunSystem(
                runSystem_runId = runSystem.runSystem_runId,
                runSystem_platform = runSystem.runSystem_platform,
                runSystem_emulated = runSystem.runSystem_emulated,
                runSystem_region = runSystem.runSystem_region,
            )
        }
    }

    fun upsertRunSystems(runSystems: List<RunSystemEntity>) {
        dbQuery.transaction { runSystems.forEach { upsertRunSystem(it) } }
    }
}
