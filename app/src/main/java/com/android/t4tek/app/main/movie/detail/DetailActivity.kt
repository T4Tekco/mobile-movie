package com.android.t4tek.app.main.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.t4tek.R
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    var binding:ActivityDetailBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val bundle:Bundle? = intent.extras
        binding?.let {

            it.imgDetailMovie.setImageResource(bundle!!.getInt("img"))
            it.tvNameDetail.text = bundle.getString("name")
            it.tvYearDetail.text = bundle.getLong("year").toString()
            it.tvContentDetail.text= bundle.getString("story")
        }
    }

}