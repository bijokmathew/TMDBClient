package com.example.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.databinding.ListItemBinding

class TvShowAdaptor():RecyclerView.Adapter<MyViewHolder>() {
    private val tvShows = ArrayList<TvShow>()

    fun setList(tvShowList:List<TvShow>){
        tvShows.clear()
        tvShows.addAll(tvShowList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflator, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }
}

class MyViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow: TvShow) {
        binding.apply {
            titleTv.text  = tvShow.name
            descriptionTv.text = tvShow.overview
            val url:String = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}