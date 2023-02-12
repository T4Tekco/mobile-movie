package com.android.t4tek.app.main.oreo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.android.t4tek.R
import com.android.t4tek.app.base.BaseFragment
import com.android.t4tek.app.main.pie.PieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OreoFragment : BaseFragment() {

    companion object {
        fun newInstance() = OreoFragment()
    }

    private val viewModel: OreoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_oreo, container, false)
    }

}