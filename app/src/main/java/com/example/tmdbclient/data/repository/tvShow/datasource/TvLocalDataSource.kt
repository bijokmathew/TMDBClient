package com.example.tmdbclient.data.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshows.TvShow

interface TvLocalDataSource {

    suspend fun getTvShows():List<TvShow>
    suspend fun saveTvShows(TvShows:List<TvShow>)
    suspend fun deleteTvShows()
}