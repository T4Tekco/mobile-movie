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

        initMovieAdapter() // set các thuộc tính của recyclerview
        getData() // lấy dữ liệu từ ViewModel
        viewModel.fetchDataMovies()
    }


    private fun getData() {
        viewModel = ViewModelProvider(this)[MovieMainVM::class.java] // xác định ViewModel MovieMainVM
        viewModel.movieLiveData.observe(this, Observer<Resource<List<JsonMovie>>> {// nhận dữ liệu
            when (it.status) { // xác định thuộc tính của dữ liệu
                Status.SUCCESS -> { // khi có dữ liệu
                    binding?.loading?.visibility = View.GONE
                    val data = it.data
                    if (data != null) {
                        movieAdapter.getListData(data,object:MovieAdapter.onItemClickListener{ //truyền tham số cho phương thức getListData của Adapter
                            override fun onItemClick(position: Int) { // phương thức click lấy thuộc tính của item adapter
                                val intent = Intent(this@MovieMain,DetailActivity::class.java)
                                intent.putExtra("img",data[position].image)
                                intent.putExtra("name",data[position].movie)
                                intent.putExtra("year",data[position].year)
                                intent.putExtra("story",data[position].story)
                                startActivity(intent)
                            }
                        })
                    }
                    movieAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> { // khi không có dữ liệu
                    Toast.makeText(this,"Erro:",Toast.LENGTH_SHORT)
                    binding?.loading?.visibility = View.GONE
                }
                Status.LOADING -> { // khi dữ liệu đang load
                    binding?.loading?.visibility = View.VISIBLE
                }
            }
        })
    }
    private fun initMovieAdapter() {
    val gridLayoutManager: GridLayoutManager = GridLayoutManager(
        this,3,GridLayoutManager.VERTICAL,false) // xét Recycler View là GridLayou
    binding?.rvMovie?.layoutManager = gridLayoutManager
    movieAdapter= MovieAdapter()
    binding?.rvMovie?.adapter = movieAdapter // Cho layout recyclerview xác định được item adapter
    binding?.rvMovie?.hasFixedSize()
    }
}

//                                val fragmet : MovieFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as MovieFragment
//                                fragmet.changeData(
//                                    data[position].image,
//                                    data[position].movie,
//                                    data[position].year,
//                                    data[position].story
//                                )