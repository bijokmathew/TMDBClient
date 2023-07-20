package com.example.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movies.Movie
import com.example.tmdbclient.databinding.ListItemBinding

class MovieAdaptor(): RecyclerView.Adapter<ViewHodler>() {
    var movieList = ArrayList<Movie>()
    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        val layoutInflator = LayoutInflater.from(parent.context)
        val listView:ListItemBinding = DataBindingUtil.inflate(layoutInflator,R.layout.list_item,parent,false)
        return ViewHodler(listView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        holder.bind(movieList[position])
    }
}

class ViewHodler(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(movie: Movie) {
        binding.apply {
            titleTv.text = movie.title
            descriptionTv.text = movie.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
            Glide.with(imageView.context).load(posterUrl).into(imageView)
        }
    }
}