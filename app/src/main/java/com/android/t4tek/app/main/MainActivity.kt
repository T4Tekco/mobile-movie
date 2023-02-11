package com.android.t4tek.app.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.android.utils.SharedPrefsUtils
import com.android.t4tek.R
import com.android.t4tek.app.main.fragment.MainFragment
import com.android.utils.NetworkHelper
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: SharedViewModel by viewModels()
    @Inject
    lateinit var shared: SharedPrefsUtils

    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        shared.saveString("android1912", "android1912")
        Timber.tag("android1912").i(shared.toString())
        shared.getString("android1912")?.let {
            Timber.tag("android1912").i(it)
        }
        Timber.tag("android1912").i(networkHelper.isNetworkConnected().toString())

    }
}