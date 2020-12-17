package com.relevanttech.bdjobs_mvvm.apps.repository.jobs


import com.relevanttech.bdjobs_mvvm.apps.core.data.localDB.AppDatabase
import com.relevanttech.bdjobs_mvvm.apps.data.networkSource.JobsNetworkSource
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.ResultResponse

import io.reactivex.Maybe


class JobsRepositoryImpl constructor(
    private val jobsNetworkSource: JobsNetworkSource,
    private val db: AppDatabase
) : JobsRepository {


    override fun getJobsList(): Maybe<ResultResponse<MutableList<JobsItem>>> {
        return jobsNetworkSource.getJobsList().onErrorResumeNext { throwable: Throwable ->
            Maybe.error(throwable)
        }.map {
            it
        }
    }

    override fun getAppDatabase(): AppDatabase {
        return db
    }

}