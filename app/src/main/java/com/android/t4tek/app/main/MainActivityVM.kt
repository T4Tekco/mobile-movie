package com.android.t4tek.app.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.t4tek.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    fun showLog(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.showLog()
        }
    }
    var isLoading = true;
    var isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
}