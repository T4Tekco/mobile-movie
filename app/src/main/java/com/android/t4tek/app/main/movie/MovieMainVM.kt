package com.android.t4tek.app.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.t4tek.app.base.BaseViewModel
import com.android.t4tek.app.utils.Resource
import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieMainVM @Inject constructor(
    private val dataRepository : MovieRepository // liên kết đến repository
) : BaseViewModel() {

    private var _movieLiveData: MutableLiveData<Resource<List<MovieEntity>>> = MutableLiveData()
    val movieLiveData : LiveData<Resource<List<MovieEntity>>> = _movieLiveData

    val isRead : Boolean = false
    fun fetchDataMovies(){
        ioScope.launch {
            //_movieLiveData.postValue(Resource.loading()) // Khi dữ liệu đang load
            try {
                dataRepository.clearData()
                val repository = dataRepository.getMovies()
                val result = dataRepository.saveMovieDb(repository)
                _movieLiveData.postValue(Resource.success(result)) // dữ liệu đã load thành công
                isRead == true
            } catch (ex: Exception) {
                _movieLiveData.postValue(
                    ex.message?.let { Resource.error(it) } // load dữ liệu bị lỗi
                )
            }
        }
    }
}