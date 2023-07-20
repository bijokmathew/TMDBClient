package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.tvshows.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>
    suspend fun updateTvShows():List<TvShow>
}