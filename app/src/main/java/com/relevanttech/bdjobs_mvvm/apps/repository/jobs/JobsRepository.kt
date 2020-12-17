package com.relevanttech.bdjobs_mvvm.apps.repository.jobs

import com.relevanttech.bdjobs_mvvm.apps.core.data.localDB.AppDatabase
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.ResultResponse

import io.reactivex.Maybe

interface JobsRepository {
    fun getJobsList(): Maybe<ResultResponse<MutableList<JobsItem>>>
    fun getAppDatabase(): AppDatabase


}