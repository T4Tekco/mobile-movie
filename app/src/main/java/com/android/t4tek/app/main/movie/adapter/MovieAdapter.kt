package com.android.t4tek.app.main.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.t4tek.R
import com.android.t4tek.data.entity.MovieEntity
import com.android.t4tek.data.json_model.JsonMovie
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var itemClick : onItemClickListener
    private var itemMovie : List<MovieEntity>? = null
    //var binding: ItemMovieBinding? = null
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun getListData(itemMovie: List<MovieEntity>, itemClick: onItemClickListener) {
        this.itemMovie = itemMovie
        this.itemClick = itemClick
    }

    inner class MovieViewHolder(view:View, itemClick: onItemClickListener): RecyclerView.ViewHolder(view){
        val imgMovie : ImageView = view.findViewById(R.id.imgMovie)
        val tvName : TextView = view.findViewById(R.id.tvName)
        val tvdirector: TextView = view.findViewById(R.id.txt_director)

        fun bin(data:MovieEntity){
        Glide.with(imgMovie)
            .load(data.image)
            .into(imgMovie)
        tvName.text = data.movie
            tvdirector.text = data.director
        }
        init {
           itemView.setOnClickListener {
               itemClick.onItemClick(adapterPosition)
           }
        }

     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(view,itemClick)
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