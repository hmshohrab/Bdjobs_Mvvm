package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions
import com.relevanttech.bdjobs_mvvm.R
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.databinding.ActivityJobsDetailsBinding

/**
 * Bismillah Hir Rahman Nir Raheem
 */

class JobsDetailsActivity : AppCompatActivity() {
    var jobsItem: JobsItem? = null
    lateinit var binding: ActivityJobsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jobsItem = intent.extras?.getSerializable("jobsItem") as JobsItem

        //Toast.makeText(this,jobsItem?.recruitingCompanySProfile.toString(),Toast.LENGTH_LONG).show()

        setJobDetails()
    }

    fun setJobDetails() {
        val jobDetails = jobsItem?.getJobDetails()
        binding.txtPositionName.text = jobDetails?.title.toString()
        binding.txtCompanyName.text = jobDetails?.companyName.toString()
        binding.txtDeadlineValue.text = jobDetails?.lastDate.toString()
        (((Glide.with(binding.root).load(jobsItem?.logo.toString())
            .skipMemoryCache(true) as RequestBuilder<*>).apply(
            (RequestOptions().override(260, 260) as BaseRequestOptions<*>)
        ).diskCacheStrategy(DiskCacheStrategy.RESOURCE) as RequestBuilder<*>).placeholder(
            ContextCompat.getDrawable(
                binding.root.context,
                R.drawable.logo
            )
        ) as RequestBuilder<*>).into(binding.imgCompanyIcon)

        if (jobsItem?.minSalary == "" && jobsItem?.maxSalary == "") {
            binding.txtSalaryValue.text = "Negotiable"
        } else if (jobsItem?.minSalary != "" && jobsItem?.maxSalary == "") {
            binding.txtSalaryValue.text = "Minimum Tk. ${jobsItem?.minSalary.toString()} (Monthly)"
        } else if (jobsItem?.minSalary == "" && jobsItem?.maxSalary != "") {
            binding.txtSalaryValue.text = "Maximum Tk. ${jobsItem?.maxSalary} (Monthly)"
        } else if (jobsItem?.minSalary != "" && jobsItem?.maxSalary != "") {
            binding.txtSalaryValue.text =
                "Tk. ${jobsItem?.minSalary.toString()} - ${jobsItem?.maxSalary} (Monthly)"
        }
        binding.txtReadAndApply.text = Html.fromHtml(jobDetails?.applyInstruction.toString())
//        Toast.makeText(this, jobsItem?.maxSalary.toString()?.toLong().toString(),Toast.LENGTH_LONG).show()

    }
}