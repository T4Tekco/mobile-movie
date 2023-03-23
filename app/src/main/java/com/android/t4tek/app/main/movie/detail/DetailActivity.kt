package com.android.t4tek.app.main.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.android.t4tek.R
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
//    lateinit var img:ImageView
//    lateinit var tvName : TextView
//    lateinit var tvYear : TextView
//    lateinit var tvStory : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle:Bundle? = intent.extras
//        img = findViewById(R.id.imgDetail_Movie)
//        tvName = findViewById(R.id.tvName_Detail)
//        tvYear = findViewById(R.id.tvYear_Detail)
//        tvStory = findViewById(R.id.tvContent_Detail)
//
//        img.setImageResource(bundle!!.getInt("img"))
//        tvName.text = bundle.getString("name")
//        tvYear.text = bundle.getLong("year").toString()
//        tvStory.text = bundle.getString("story")
        binding.let {
            it.imgDetailMovie.setImageResource(bundle!!.getInt("img"))
            it.tvNameDetail.text = bundle.getString("name")
            it.tvYearDetail.text = bundle.getLong("year").toString()
            it.tvContentDetail.text= bundle.getString("story")
        }
    }

}