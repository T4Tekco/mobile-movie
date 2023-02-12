package com.android.t4tek.app.main.pie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseFragment
import com.android.t4tek.app.main.fragment.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PieFragment : BaseFragment() {

    companion object {
        fun newInstance() = PieFragment()
    }

    private val viewModel: PieViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val argInt = it.getInt(getString(R.string.nav_arg_to_pie_int))
            val argString = it.getString(getString(R.string.nav_arg_to_pie_string))
            Timber.tag("hanhmh1203").i("arguments int: $argInt")
            Timber.tag("hanhmh1203").i("arguments string: $argString")
        }
    }

}