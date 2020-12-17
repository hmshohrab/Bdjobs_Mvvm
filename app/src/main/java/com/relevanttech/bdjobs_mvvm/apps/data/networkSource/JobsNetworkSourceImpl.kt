package com.relevanttech.bdjobs_mvvm.apps.data.networkSource


import android.content.Context
import com.relevanttech.bdjobs_mvvm.apps.core.data.network.ApiService
import com.relevanttech.bdjobs_mvvm.apps.core.data.network.NetworkFactory
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.ResultResponse
import io.reactivex.Maybe

/**
 * Bismillah Hir Rahman Nir Raheem
 */
class JobsNetworkSourceImpl constructor(private val context: Context) : JobsNetworkSource {
    private fun getApiService(): ApiService {
        return NetworkFactory.createService(context, ApiService::class.java)
    }

    override fun getJobsList(): Maybe<ResultResponse<MutableList<JobsItem>>> {

        return getApiService().getJobsList().map {
            if (it.isSuccessful) {
                if (it.body() != null) {
                    it.body()
                } else {
                    throw Exception("Request Exception")
                }
            } else {
                throw Exception(it.message())
            }
        }
    }
}