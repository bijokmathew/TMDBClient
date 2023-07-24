package com.example.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.databinding.ListItemBinding

class ArtistAdaptor():RecyclerView.Adapter<MyViewHolder>() {
    var artistList = ArrayList<Artist>()

    fun setList(artist: List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(inflator,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}

class MyViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(artist: Artist) {
        binding.apply {
            titleTv.text = artist.name
            descriptionTv.text = artist.popularity.toString()
            val url = "https://image.tmdb.org/t/p/w500"+artist.profilePath
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}