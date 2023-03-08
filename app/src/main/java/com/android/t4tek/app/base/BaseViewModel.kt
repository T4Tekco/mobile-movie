package com.android.t4tek.app.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import timber.log.Timber

abstract class BaseViewModel: ViewModel() {
    private val viewModelJob = SupervisorJob()
    protected val mainDispatcher =  Dispatchers.Main
    protected val ioDispatcher =  Dispatchers.IO
    protected val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    protected val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)
    override fun onCleared() {
        uiScope.cancel()
        ioScope.cancel()
        ioDispatcher.cancel()
        mainDispatcher.cancel()
        super.onCleared()
    }
}