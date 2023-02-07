package com.android.t4tek.domain.repository

import android.util.Log
import androidx.annotation.WorkerThread

interface UserRepository {
    fun showLog()
    @WorkerThread
    fun insertRandomRecord()
}