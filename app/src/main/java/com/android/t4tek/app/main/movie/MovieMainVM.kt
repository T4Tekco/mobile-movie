package com.android.t4tek.app.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.t4tek.app.base.BaseViewModel
import com.android.t4tek.app.utils.Resource
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.data.repository.UserRepository
import com.android.t4tek.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieMainVM @Inject constructor(
    private val dataRepository : UserRepositoryImpl
) : BaseViewModel() {

    private var _movieLiveData: MutableLiveData<Resource<List<JsonMovie>>> = MutableLiveData()
    val movieLiveData : LiveData<Resource<List<JsonMovie>>> = _movieLiveData

    

    fun fetchDataMovies(){
        ioScope.launch {
            _movieLiveData.postValue(Resource.loading())
            try {
                val result = dataRepository.getMovies()
                _movieLiveData.postValue(Resource.success(result))
            } catch (ex: Exception) {
                _movieLiveData.postValue(
                    ex.message?.let { Resource.error(it) }
                )
            }
        }
    }
}