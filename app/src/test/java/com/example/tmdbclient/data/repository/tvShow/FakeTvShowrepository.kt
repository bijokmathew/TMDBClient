package com.example.tmdbclient.data.repository.tvShow

import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class FakeTvShowrepository: TvShowRepository {

    private val tvShows = mutableListOf<TvShow>()
    init {
        tvShows.add(TvShow("date",1,"name","overv","path"))
        tvShows.add(TvShow("date",2,"name","overv","path"))
    }
    override suspend fun getTvShows(): List<TvShow> {
        return tvShows
    }

    override suspend fun updateTvShows(): List<TvShow> {
        tvShows.clear()
        tvShows.add(TvShow("date",3,"name","overv","path"))
        tvShows.add(TvShow("date",4,"name","overv","path"))
        return  tvShows
    }
}