package com.relevanttech.bdjobs_mvvm.apps.core.data.network

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Bismillah Hir Rahman Nir Raheem
 */
object RxJavaDisposableManager {
    private var compositeDisposable: CompositeDisposable? = null

    fun add(disposable: Disposable) {
        getCompositeDisposable().add(disposable)
    }

    fun dispose() {
        getCompositeDisposable().dispose()
    }

    private fun getCompositeDisposable(): CompositeDisposable {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        return compositeDisposable!!
    }

}