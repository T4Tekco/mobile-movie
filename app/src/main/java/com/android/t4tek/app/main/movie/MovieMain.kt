package com.android.t4tek.app.main.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.t4tek.app.main.movie.adapter.MovieAdapter
import com.android.t4tek.app.utils.Status
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.databinding.ActivityMovieMainBinding

class MovieMain : AppCompatActivity() {

    var binding: ActivityMovieMainBinding? =null
    lateinit var movieAdapter : MovieAdapter
    private lateinit var viewModel : MovieMainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        viewModel = ViewModelProvider(this)[MovieMainVM::class.java]

        getData()
        viewModel.fetchDataMovies()
        initMovieAdapter()


    }

    private fun getData() {
        viewModel.movieLiveData.observe(this, Observer {response->
            when (response.status) {
                Status.SUCCESS -> {
                    binding?.loading?.visibility = View.GONE
                    movieAdapter.getListData(response.data)
                }
                Status.ERROR -> {
                    binding?.loading?.visibility = View.GONE
                }
                Status.LOADING -> {
                    binding?.loading?.visibility = View.VISIBLE
                }
            }
        })
    }
    private fun initMovieAdapter() {
        val gridLayoutManager: GridLayoutManager = GridLayoutManager(this,3)
        binding?.rvMovie?.layoutManager = gridLayoutManager
        movieAdapter= MovieAdapter()
2
        binding?.rvMovie?.adapter = movieAdapter
    }
}