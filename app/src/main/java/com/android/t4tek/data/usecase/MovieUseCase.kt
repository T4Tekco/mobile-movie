package com.android.t4tek.data.usecase

import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.repository.MovieRepository
import com.android.t4tek.data.repository.UserRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository : MovieRepository
) {

}