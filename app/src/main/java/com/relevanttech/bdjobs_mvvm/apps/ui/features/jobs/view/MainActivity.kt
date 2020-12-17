package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view.controller.JobsController
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.viewModel.MainViewModel
import com.relevanttech.bdjobs_mvvm.databinding.ActivityMainBinding

/**
 * Bismillah Hir Rahman Nir Raheem
 */

class MainActivity : AppCompatActivity() {
    var jobsItemList: MutableList<JobsItem>? = null
    lateinit var binding: ActivityMainBinding
    lateinit var jobsController: JobsController


    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        jobsItemList = mutableListOf()
        jobsController = JobsController()
        binding.rcJobs.layoutManager = LinearLayoutManager(this)

        binding.rcJobs.adapter = jobsController.adapter
        jobsController.setFilterDuplicates(true)
        jobsController.activity = this

        mainViewModel.setRepository(this)

        observer()
    }

    private fun observer() {
        mainViewModel.progress.observe(this) {
            binding.pbHome.visibility = if (it) View.VISIBLE else View.GONE
        }
        mainViewModel.jobsItemListLiveData.observe(this) {
            jobsItemList = it
            jobsController.setData(it)
        }

        mainViewModel.isError.observe(this) {
            showErrorSnack(this, it)
        }

    }


    fun startActivity(clz: Class<*>?, bundle: Bundle?) {
        val intent = Intent(this, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    private fun showErrorSnack(activity: Activity, message: String?) {
        try {
            Snackbar.make(
                activity.findViewById(android.R.id.content), message!!,
                Snackbar.LENGTH_LONG
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
