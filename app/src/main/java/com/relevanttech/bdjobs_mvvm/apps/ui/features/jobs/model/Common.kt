package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Bismillah Hir Rahman Nir Raheem
 */
class Common : Serializable {
    @SerializedName("total_records_found")
    @Expose
    var totalRecordsFound: Long? = null

    @SerializedName("totalpages")
    @Expose
    var totalpages: Long? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param totalpages
     * @param totalRecordsFound
     */
    constructor(totalRecordsFound: Long?, totalpages: Long?) : super() {
        this.totalRecordsFound = totalRecordsFound
        this.totalpages = totalpages
    }

    companion object {
        private const val serialVersionUID = 1393590462700309498L
    }
}