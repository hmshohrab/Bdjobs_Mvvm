package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Bismillah Hir Rahman Nir Raheem
 */

class JobDetails : Serializable {
    @SerializedName("Title")
    @Expose
    var title: String? = null

    @SerializedName("LastDate")
    @Expose
    var lastDate: String? = null

    @SerializedName("CompanyName")
    @Expose
    var companyName: String? = null

    @SerializedName("ApplyInstruction")
    @Expose
    var applyInstruction: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param companyName
     * @param title
     * @param applyInstruction
     * @param lastDate
     */
    constructor(
        title: String?,
        lastDate: String?,
        companyName: String?,
        applyInstruction: String?
    ) : super() {
        this.title = title
        this.lastDate = lastDate
        this.companyName = companyName
        this.applyInstruction = applyInstruction
    }

    companion object {
        private const val serialVersionUID = 5123699489566423268L
    }
}