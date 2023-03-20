package com.android.t4tek.app.main.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.AdapterChanges
import com.android.t4tek.R
import com.android.t4tek.data.json_model.JsonMovie
import com.android.t4tek.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var itemMovie : List<JsonMovie>
    lateinit var binding: ItemMovieBinding


    fun getListData(itemMovie: List<JsonMovie>) {
        this.itemMovie = itemMovie
    }

    inner class MovieViewHolder(view:View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemMovie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(binding.imgMovie).load(itemMovie[position].image).into(binding.imgMovie)
            binding.tvName.text = itemMovie[position].movie
        }
    }
}