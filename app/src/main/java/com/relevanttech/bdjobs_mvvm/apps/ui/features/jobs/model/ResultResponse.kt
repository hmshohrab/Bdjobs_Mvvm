package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Bismillah Hir Rahman Nir Raheem
 */
class ResultResponse<T> : Serializable {
    @SerializedName("statuscode")
    @Expose
    var statuscode: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: T? = null

    @SerializedName("common")
    @Expose
    var common: Common? = null

    companion object {
        private const val serialVersionUID = -3970236718461632572L
    }
}