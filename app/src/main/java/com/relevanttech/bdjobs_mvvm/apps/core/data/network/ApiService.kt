package com.relevanttech.bdjobs_mvvm.apps.core.data.network

import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.ResultResponse
import io.reactivex.Maybe
import retrofit2.Response
import retrofit2.http.GET

/**
 * Bismillah Hir Rahman Nir Raheem
 */
interface ApiService {
    @GET("http://corporate3.bdjobs.com/interviewtest/InterviewJson.json")
    fun getJobsList(): Maybe<Response<ResultResponse<MutableList<JobsItem>>>>
}