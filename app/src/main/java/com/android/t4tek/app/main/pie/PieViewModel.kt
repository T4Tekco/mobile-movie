package com.android.t4tek.app.main.pie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.t4tek.app.base.BaseViewModel
import com.android.t4tek.app.utils.Resource
import com.android.t4tek.data.entity.PersonEntity
import com.android.t4tek.data.json_model.JsonPerson
import com.android.t4tek.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PieViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {
    private var _personLoader: MutableLiveData<Resource<List<PersonEntity>>> = MutableLiveData()
    val personLoader: LiveData<Resource<List<PersonEntity>>> = _personLoader
    fun fetchPerson() {
        ioScope.launch {
            _personLoader.postValue(Resource.loading())
            try {
                val result = userRepository.getPersonApi()
                val persons = result.map { it.toEntity() }.toList()
                _personLoader.postValue(Resource.success(persons))
            } catch (ex: Exception) {
                _personLoader.postValue(
                    ex.message?.let { Resource.error(it) }
                )
            }
        }
    }
}