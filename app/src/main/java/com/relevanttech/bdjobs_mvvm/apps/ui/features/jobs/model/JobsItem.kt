package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Bismillah Hir Rahman Nir Raheem
 */

class JobsItem : Serializable {
    @SerializedName("jobTitle")
    @Expose
    var jobTitle: String? = null

    @SerializedName("deadline")
    @Expose
    var deadline: String? = null

    @SerializedName("recruitingCompany'sProfile")
    @Expose
    var recruitingCompanySProfile: String? = null

    @SerializedName("jobDetails")
    @Expose
    private var jobDetails: JobDetails? = null

    @SerializedName("logo")
    @Expose
    var logo: String? = null

    @SerializedName("IsFeatured")
    @Expose
    var isFeatured: Boolean? = null

    @SerializedName("minExperience")
    @Expose
    var minExperience: Long? = null

    @SerializedName("maxExperience")
    @Expose
    var maxExperience: Long? = null

    @SerializedName("minSalary")
    @Expose
    var minSalary: String? = null

    @SerializedName("maxSalary")
    @Expose
    var maxSalary: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param maxSalary
     * @param recruitingCompanySProfile
     * @param jobTitle
     * @param logo
     * @param maxExperience
     * @param minSalary
     * @param deadline
     * @param jobDetails
     * @param isFeatured
     * @param minExperience
     */
    constructor(
        jobTitle: String?,
        deadline: String?,
        recruitingCompanySProfile: String?,
        jobDetails: JobDetails?,
        logo: String?,
        isFeatured: Boolean?,
        minExperience: Long?,
        maxExperience: Long?,
        minSalary: String?,
        maxSalary: String?
    ) : super() {
        this.jobTitle = jobTitle
        this.deadline = deadline
        this.recruitingCompanySProfile = recruitingCompanySProfile
        this.jobDetails = jobDetails
        this.logo = logo
        this.isFeatured = isFeatured
        this.minExperience = minExperience
        this.maxExperience = maxExperience
        this.minSalary = minSalary
        this.maxSalary = maxSalary
    }

    fun getJobDetails(): JobDetails? {
        return jobDetails
    }

    fun setJobDetails(jobDetails: JobDetails?) {
        this.jobDetails = jobDetails
    }

    companion object {
        private const val serialVersionUID = -1533803227791246534L
    }
}

