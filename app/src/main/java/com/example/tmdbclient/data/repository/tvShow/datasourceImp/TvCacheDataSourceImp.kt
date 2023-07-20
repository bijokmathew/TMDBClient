package com.example.tmdbclient.data.repository.tvShow.datasourceImp

import com.example.tmdbclient.data.model.tvshows.TvShow
import com.example.tmdbclient.data.repository.tvShow.datasource.TvCacheDataSource
import kotlinx.coroutines.CoroutineScope

class TvCacheDataSourceImp: TvCacheDataSource {
    private var tvshowsList = ArrayList<TvShow>()
    override suspend fun getTvShows(): List<TvShow> =tvshowsList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvshowsList.addAll(tvShows)
    }
}