package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view.controller

import android.app.Activity
import android.os.Bundle
import com.airbnb.epoxy.TypedEpoxyController
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view.JobsDetailsActivity
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view.MainActivity
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view.controller.epoxyModel.JobsEpoxyModel_
import com.relevanttech.bdjobs_mvvm.databinding.ItemJoblistBinding

/**
 * Bismillah Hir Rahman Nir Raheem
 */

class JobsController : TypedEpoxyController<MutableList<JobsItem>>() {
    var activity: Activity? = null
    override fun buildModels(data: MutableList<JobsItem>) {
        data.forEachIndexed { index, jobsItem ->
            JobsEpoxyModel_().apply {
                id("Jobs_$index")
                model = jobsItem
                listener { model, parentView, clickedView, position ->
                    val bundle = Bundle()
                    bundle.putSerializable("jobsItem", model.model)
                    if (activity is MainActivity) {
                        (activity as MainActivity).startActivity(
                            JobsDetailsActivity::class.java,
                            bundle
                        )
                    }
                }

            }.onBind { model, view, position ->
                val itemJoblistBinding: ItemJoblistBinding = view.dataBinding as ItemJoblistBinding

            }.addTo(this)
        }
    }


    private fun setActivitys(activity: Activity) {
        this.activity = activity
    }

}