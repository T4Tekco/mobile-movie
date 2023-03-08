package com.android.t4tek.app.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.t4tek.app.base.BaseViewModel
import com.android.t4tek.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    var isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    fun loadUser(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = userRepository.getPersonApi()
            Timber.tag("MainActivityVM").i(result.toString())
        }
    }
}