package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.viewModel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.relevanttech.bdjobs_mvvm.apps.core.data.localDB.AppDatabase
import com.relevanttech.bdjobs_mvvm.apps.core.data.network.RxJavaDisposableManager
import com.relevanttech.bdjobs_mvvm.apps.data.networkSource.JobsNetworkSourceImpl
import com.relevanttech.bdjobs_mvvm.apps.repository.jobs.JobsRepository
import com.relevanttech.bdjobs_mvvm.apps.repository.jobs.JobsRepositoryImpl
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Bismillah Hir Rahman Nir Raheem
 */

class MainViewModel : ViewModel() {

    var progress: MutableLiveData<Boolean> = MutableLiveData()
    var jobsItemListLiveData: MutableLiveData<MutableList<JobsItem>> = MutableLiveData()
    var isError: MutableLiveData<String> = MutableLiveData()
    private var repository: JobsRepository? = null
    var appDatabase: AppDatabase? = null

    fun setRepository(activity: Activity) {
        appDatabase = AppDatabase.getInstance(activity)
        repository = JobsRepositoryImpl(JobsNetworkSourceImpl(activity), appDatabase!!)

        getJobsItemList()
    }


    private fun getJobsItemList() {

        progress.postValue(true)
        val disposable = repository!!.getJobsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                jobsItemListLiveData.postValue(it.data)
                progress.postValue(false)
            }, {
                isError.postValue(it.localizedMessage)
                progress.postValue(false)
                it.printStackTrace()
            })
        RxJavaDisposableManager.add(disposable)
    }

}