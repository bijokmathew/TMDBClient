package com.example.tmdbclient.data.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshows.TvShow

interface TvCacheDataSource {

    suspend fun getTvShows():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)

}