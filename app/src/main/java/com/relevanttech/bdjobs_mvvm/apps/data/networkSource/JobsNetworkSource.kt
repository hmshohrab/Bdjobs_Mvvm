package com.relevanttech.bdjobs_mvvm.apps.data.networkSource

import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.ResultResponse
import io.reactivex.Maybe


/**
 * Bismillah Hir Rahman Nir Raheem
 */
interface JobsNetworkSource {
    fun getJobsList(): Maybe<ResultResponse<MutableList<JobsItem>>>

}