package com.android.t4tek.app

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
//        Scabbard.initialize(
//            this, Builder()
//                .setGenerateGraphvizFiles(BuildConfig.DEBUG)
//                .build()
//        )
    }
}