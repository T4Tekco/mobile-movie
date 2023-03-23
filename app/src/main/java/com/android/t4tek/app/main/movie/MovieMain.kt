package com.android.t4tek.app.main.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.t4tek.app.main.movie.adapter.MovieAdapter
import com.android.t4tek.app.main.movie.detail.DetailActivity
import com.android.t4tek.app.utils.Resource
import com.android.t4tek.app.utils.Status
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.databinding.ActivityMovieMainBinding


import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
@AndroidEntryPoint
class MovieMain : AppCompatActivity() {

    var binding: ActivityMovieMainBinding? = null
    lateinit var movieAdapter : MovieAdapter
    private lateinit var viewModel : MovieMainVM
    //lateinit var movieList : List<JsonMovie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val gridLayoutManager: GridLayoutManager = GridLayoutManager(
            this,3,GridLayoutManager.VERTICAL,false)
        binding?.rvMovie?.layoutManager = gridLayoutManager
        movieAdapter= MovieAdapter()
        binding?.rvMovie?.adapter = movieAdapter
        binding?.rvMovie?.hasFixedSize()

        viewModel = ViewModelProvider(this)[MovieMainVM::class.java]
        viewModel.movieLiveData.observe(this, Observer<Resource<List<JsonMovie>>> {
            when (it.status) {
                Status.SUCCESS -> {
                    binding?.loading?.visibility = View.GONE
                    val data = it.data
                    if (data != null) {
                        movieAdapter.getListData(data,object:MovieAdapter.onItemClickListener{
                            override fun onItemClick(position: Int) {
//                                Toast.makeText(this@MovieMain,"Thành Công ${data[position].movie}",Toast.LENGTH_SHORT)
//                                    .show()
                                val intent = Intent(this@MovieMain,DetailActivity::class.java)
                                intent.putExtra("img",data[position].image)
                                intent.putExtra("name",data[position].movie)
                                intent.putExtra("year",data[position].year)
                                intent.putExtra("story",data[position].story)
                                startActivity(intent)
//                                val fragmet : MovieFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as MovieFragment
//                                fragmet.changeData(
//                                    data[position].image,
//                                    data[position].movie,
//                                    data[position].year,
//                                    data[position].story
//                                )
                            }
                        })
                    }
                    movieAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    Toast.makeText(this,"Erro:",Toast.LENGTH_SHORT)
                    binding?.loading?.visibility = View.GONE
                }
                Status.LOADING -> {

                    binding?.loading?.visibility = View.VISIBLE
                }
            }
        })
        viewModel.fetchDataMovies()

    }


//    private fun getData() {
//        viewModel.movieLiveData.observe(this, Observer {response->
//            when (response.status) {
//                Status.SUCCESS -> {
//                    binding?.loading?.visibility = View.GONE
//                    movieAdapter.getListData(response.data)
//
//                }
//                Status.ERROR -> {
//                    binding?.loading?.visibility = View.GONE
//                }
//                Status.LOADING -> {
//                    binding?.loading?.visibility = View.VISIBLE
//                }
//            }
//        })
//    }
//    private fun getLiveData(): List<JsonMovie> {
//        return ArrayList()
//    }
//
//    private fun initMovieAdapter() {
//        val gridLayoutManager: GridLayoutManager = GridLayoutManager(this,3)
//        binding?.rvMovie?.layoutManager = gridLayoutManager
//        movieAdapter= MovieAdapter()
//        binding?.rvMovie?.adapter = movieAdapter
//    }
}