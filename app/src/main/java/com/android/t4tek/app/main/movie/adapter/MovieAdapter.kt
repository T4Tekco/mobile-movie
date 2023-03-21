package com.android.t4tek.app.main.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.AdapterChanges
import com.android.t4tek.R
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var itemMovie : List<JsonMovie>? = null
    //var binding: ItemMovieBinding? = null


    fun getListData(itemMovie: List<JsonMovie>) {
        this.itemMovie = itemMovie
    }

    class MovieViewHolder(view:View): RecyclerView.ViewHolder(view){
        val imgMovie : ImageView = view.findViewById(R.id.imgMovie)
        val tvName : TextView = view.findViewById(R.id.tvName)
        fun bin(data:JsonMovie){
            Glide.with(imgMovie)
                .load(data.image)
                .into(imgMovie)
            tvName.text = data.movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(itemMovie == null)
            0
        else itemMovie?.size!!
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bin(itemMovie!![position])
//        holder.itemView.apply {
//            Glide.with(binding!!.imgMovie)
//                .load(itemMovie?.get(position)?.image)
//                .into(binding!!.imgMovie)
//            binding?.tvName?.text = itemMovie?.get(position)?.movie
//        }
    }
}